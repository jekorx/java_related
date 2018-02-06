package com.ssm.dao;

import com.ssm.entity.Seckill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

/**
 * 配置spring和junit整合
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {

    @Resource
    private SeckillDao seckillDao;

    @Test
    public void reduceNumber() throws Exception {
        long id = 1000L;

        int reduceNumber = seckillDao.reduceNumber(id, new Date());

        System.out.println(reduceNumber);
    }

    @Test
    public void queryById() throws Exception {
        Seckill seckill = seckillDao.queryById(1000L);
        System.out.println(seckill);
    }

    @Test
    public void queryAll() throws Exception {
        List<Seckill> seckills = seckillDao.queryAll(0, 2);
        for (Seckill seckill : seckills) {
            System.out.println(seckill);
        }
    }

}