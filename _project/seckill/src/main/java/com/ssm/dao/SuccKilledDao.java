package com.ssm.dao;

import com.ssm.entity.SuccKilled;
import org.apache.ibatis.annotations.Param;

public interface SuccKilledDao {

    /**
     * 插入购买明细，可以过滤重复
     * @param seckillId
     * @param userPhone
     * @return
     */
    int insertSuccKilled(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);

    /**
     * 根据id和phone查询SuccKilled并携带Seckill
     * @param seckillId
     * @param userPhone
     * @return
     */
    SuccKilled queryByIdAndPhoneWithSeckill(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);

}
