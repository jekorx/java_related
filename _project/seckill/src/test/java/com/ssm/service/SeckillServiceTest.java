package com.ssm.service;

import com.ssm.dto.Exposer;
import com.ssm.dto.SeckillExecution;
import com.ssm.entity.Seckill;
import com.ssm.exception.SeckillCloseException;
import com.ssm.exception.SeckillRepeatException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class SeckillServiceTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillService seckillService;

    @Test
    public void getSeckillList() throws Exception {
        List<Seckill> seckillList = seckillService.getSeckillList();
        for (Seckill seckill : seckillList) {
            System.out.println(seckill);
        }
    }

    @Test
    public void getById() throws Exception {
        Seckill seckill = seckillService.getById(1000L);
        logger.info("seckill = {}", seckill);
    }

    @Test
    public void seckillLogic() throws Exception {
        long id = 1000L;
        long phone = 13811111112L;
        Exposer exposer = seckillService.exportSeckillUrl(id);
        if (exposer.isExposed()) {
            logger.info("exposer = {}", exposer);
            String md5 = exposer.getMd5();
            try {
                SeckillExecution seckillExecution = seckillService.executeSeckill(exposer.getSeckillId(), phone, md5);
                logger.info("result = {}", seckillExecution);
            } catch (SeckillCloseException sce) {
                logger.error(sce.getMessage());
            } catch (SeckillRepeatException sre) {
                logger.error(sre.getMessage());
            }
        } else {
            logger.warn("exposer = {}", exposer);
        }
    }

    @Test
    public void executeSeckillProcedure() throws Exception {
        long id = 1000L;
        long phone = 14114114112L;
        Exposer exposer = seckillService.exportSeckillUrl(id);
        if (exposer.isExposed()) {
            logger.info("exposer = {}", exposer);
            String md5 = exposer.getMd5();
            SeckillExecution seckillExecution = seckillService.executeSeckillProcedure(exposer.getSeckillId(), phone, md5);
            logger.info("result = {}", seckillExecution);
        }
    }

}