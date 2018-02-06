package com.ssm.service.impl;

import com.ssm.dao.SeckillDao;
import com.ssm.dao.SuccKilledDao;
import com.ssm.dao.cache.RedisDao;
import com.ssm.dto.Exposer;
import com.ssm.dto.SeckillExecution;
import com.ssm.entity.Seckill;
import com.ssm.entity.SuccKilled;
import com.ssm.enums.SeckillStatEnum;
import com.ssm.exception.SeckillCloseException;
import com.ssm.exception.SeckillException;
import com.ssm.exception.SeckillRepeatException;
import com.ssm.service.SeckillService;
import org.apache.commons.collections4.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 执行秒杀业务逻辑实现类
 */
@Service
public class SeckillServiceImpl implements SeckillService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // md5盐值字符串，用于混淆
    private static final String SLAT = "js3shk*(&}{(gjs{}ahkd321s3#%?";

    // 注入SeckillDao依赖
    @Autowired
    private SeckillDao seckillDao;

    // 注入SuccKilledDao依赖
    @Autowired
    private SuccKilledDao succKilledDao;

    // 注入redisDao
    @Autowired
    private RedisDao redisDao;

    public List<Seckill> getSeckillList() {
        return seckillDao.queryAll(0, 10);
    }

    public Seckill getById(long seckillId) {
        return seckillDao.queryById(seckillId);
    }

    public Exposer exportSeckillUrl(long seckillId) {
        // 访问redis
        Seckill seckill = redisDao.getSeckill(seckillId);
        if (seckill == null) {
            // redis没有缓存，访问数据库
            seckill = seckillDao.queryById(seckillId);
            if (seckill == null) {
                return new Exposer(false, seckillId);
            } else {
                // 将数据缓存如redis
                redisDao.putSeckill(seckill);
            }
        }

        /*Seckill */

        long start = seckill.getStartTime().getTime();
        long end = seckill.getEndTime().getTime();
        long now = new Date().getTime();

        // 秒杀没开始或者结束
        if (now < start || now > end) {
            return new Exposer(false, seckillId, now, start, end);
        }

        String md5 = getMd5Str(seckillId);

        return new Exposer(true, md5, seckillId);
    }

    /**
     * 建议使用基于注解的声明式事务处理，好处：
     *   1、开发团队统一达成约定，明确标注事务方法的编程风格
     *   2、尽可能使事务控制的范围最小，执行的时间最短，
     *      尽量不要在事务中进行RPC/HTTP等网络请求，如果需要，则剥离到事务方法之外
     *   3、不是所有方法都需要事务，比如一次修改操作或者只读操作不需要事务控制
     * @param seckillId
     * @param userPhone
     * @param md5
     * @return
     */
    @Transactional
    public SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
            throws SeckillException, SeckillCloseException, SeckillRepeatException {
        if (md5 == null || !md5.equals(getMd5Str(seckillId))) {
            throw new SeckillException(SeckillStatEnum.REWRITE.getStateInfo());
        }
        try {
            // 记录秒杀行为
            int insertCount = succKilledDao.insertSuccKilled(seckillId, userPhone);
            // seckillId, userPhone联合主键，唯一
            if (insertCount <= 0) {
                // 重复秒杀
                throw new SeckillRepeatException(SeckillStatEnum.REPEAT.getStateInfo());
            } else {
                // 减库存
                int updateCount = seckillDao.reduceNumber(seckillId, new Date());
                if (updateCount <= 0) {
                    // 没有更新记录，秒杀结束
                    throw new SeckillCloseException(SeckillStatEnum.ENDED.getStateInfo());
                } else {
                    // 秒杀成功
                    SuccKilled succKilled = succKilledDao.queryByIdAndPhoneWithSeckill(seckillId, userPhone);
                    // 返回秒杀结果
                    return new SeckillExecution(seckillId, SeckillStatEnum.SUCCESS, succKilled);
                }
            }
        } catch (SeckillCloseException sce) {
            throw sce;
        } catch (SeckillRepeatException sre) {
            throw sre;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new SeckillException(SeckillStatEnum.FAILED.getStateInfo() + ":" + e.getMessage());
        }
    }

    public SeckillExecution executeSeckillProcedure(long seckillId, long userPhone, String md5)
            throws SeckillException, SeckillCloseException, SeckillRepeatException {
        if (md5 == null || !md5.equals(getMd5Str(seckillId))) {
            throw new SeckillException(SeckillStatEnum.REWRITE.getStateInfo());
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("seckillId", seckillId);
        map.put("phone", userPhone);
        map.put("killTime", new Date());
        map.put("result", null);
        // 执行存储过程，result会被赋值
        try {
            seckillDao.killByProcedure(map);
            int result = MapUtils.getInteger(map, "result", -2);
            if (result == 0) {
                SuccKilled succKilled = succKilledDao.queryByIdAndPhoneWithSeckill(seckillId, userPhone);
                // 返回秒杀结果
                return new SeckillExecution(seckillId, SeckillStatEnum.SUCCESS, succKilled);
            } else {
                return new SeckillExecution(seckillId, SeckillStatEnum.stateOf(result));
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new SeckillException(SeckillStatEnum.FAILED.getStateInfo() + ":" + e.getMessage());
        }
    }

    // 获取md5加密串
    private String getMd5Str(long seckillId) {
        String base = seckillId + "/" + SLAT;
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }
}
