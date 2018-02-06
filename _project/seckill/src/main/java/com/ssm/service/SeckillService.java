package com.ssm.service;

import com.ssm.dto.Exposer;
import com.ssm.dto.SeckillExecution;
import com.ssm.entity.Seckill;
import com.ssm.exception.SeckillCloseException;
import com.ssm.exception.SeckillException;
import com.ssm.exception.SeckillRepeatException;

import java.util.List;

/**
 * 业务逻辑接口：应站在“使用者”角度设计接口
 * 三个方面：方法定义粒度、参数、返回值类型（return 类型/异常）
 */
public interface SeckillService {

    /**
     * 查询所有记录
     * @return
     */
    List<Seckill> getSeckillList();

    /**
     * 查询单个记录
     * @param seckillId
     * @return
     */
    Seckill getById(long seckillId);

    /**
     * 秒杀开启，输出秒杀地址
     * @param seckillId
     * @return
     */
    Exposer exportSeckillUrl(long seckillId);

    /**
     * 执行秒杀操作
     * @param seckillId
     * @param userPhone
     * @param md5
     * @return
     * @throws SeckillException
     * @throws SeckillCloseException
     * @throws SeckillRepeatException
     */
    SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
        throws SeckillException, SeckillCloseException, SeckillRepeatException;

    /**
     * 存储过程执行秒杀操作
     * @param seckillId
     * @param userPhone
     * @param md5
     * @return
     * @throws SeckillException
     * @throws SeckillCloseException
     * @throws SeckillRepeatException
     */
    SeckillExecution executeSeckillProcedure(long seckillId, long userPhone, String md5)
            throws SeckillException, SeckillCloseException, SeckillRepeatException;

}
