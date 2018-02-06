package com.ssm.dao;

import com.ssm.entity.SuccKilled;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SuccKilledDaoTest {

    @Resource
    private SuccKilledDao succKilledDao;

    @Test
    public void insertSuccKilled() throws Exception {
        int insertSuccKilled = succKilledDao.insertSuccKilled(1000L, 13811111111L);
        System.out.println(insertSuccKilled);
    }

    @Test
    public void queryByIdAndPhoneWithSeckill() throws Exception {
        SuccKilled succKilled = succKilledDao.queryByIdAndPhoneWithSeckill(1000L, 13811111111L);
        System.out.println(succKilled);
    }

}