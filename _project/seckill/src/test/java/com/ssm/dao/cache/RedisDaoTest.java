package com.ssm.dao.cache;

import com.ssm.dao.SeckillDao;
import com.ssm.entity.Seckill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class RedisDaoTest {

    private long id = 1000;

    @Autowired
    private RedisDao redisDao;

    @Autowired
    private SeckillDao seckillDao;

    @Test
    public void redisDaoTest() throws Exception {
        Seckill seckill = redisDao.getSeckill(id);
        if (seckill == null) {
            seckill = seckillDao.queryById(id);
            redisDao.putSeckill(seckill);

            Seckill sk = redisDao.getSeckill(id);
            System.out.println(sk);

        } else {
            System.out.println(seckill);
        }
    }

}