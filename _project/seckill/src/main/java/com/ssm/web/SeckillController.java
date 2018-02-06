package com.ssm.web;

import com.ssm.dto.Exposer;
import com.ssm.dto.SeckillExecution;
import com.ssm.entity.Seckill;
import com.ssm.enums.ResultCodeEnum;
import com.ssm.enums.SeckillStatEnum;
import com.ssm.exception.SeckillCloseException;
import com.ssm.exception.SeckillRepeatException;
import com.ssm.service.SeckillService;
import com.ssm.util.ResultUtil;
import com.ssm.vo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * url:/模块/资源/{id}/细分
 */
@Controller
@RequestMapping("/seckill")
public class SeckillController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // 注入SeckillService依赖
    @Autowired
    private SeckillService seckillService;

    /**
     * 获取列表
     * @param model
     * @return
     */
    @GetMapping("/list")
    public String list(Model model) {
        List<Seckill> list = seckillService.getSeckillList();
        model.addAttribute("list", list);
        return "list";
    }

    @GetMapping("/{seckillId}/detail")
    public String detail(@PathVariable("seckillId") long seckillId, Model model) {
        if (seckillId <= 0L) {
            // 间接转发方式（Redirect）
            // "A找B借钱，B说没有，让A去找C借"
            return "redirect:/seckill/list";
        }
        Seckill seckill = seckillService.getById(seckillId);
        if (seckill == null) {
            // 直接转发方式（Forward）
            // “A找B借钱，B说没有，B去找C借，借到借不到都会把消息传递给A”
            return "forward:/seckill/list";
        }
        model.addAttribute("seckill", seckill);
        return "detail";
    }

    /**
     * 输出秒杀地址
     * @param seckillId
     * @return
     */
    @PostMapping("/{seckillId}/exposer")
    @ResponseBody
    public Result<Exposer> export(@PathVariable("seckillId") long seckillId) {
        try {
            Exposer exposer = seckillService.exportSeckillUrl(seckillId);
            return ResultUtil.success(exposer);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return ResultUtil.error(e.getMessage());
        }
    }

    /**
     * 执行秒杀操作
     * @param seckillId
     * @param md5
     * @param phone
     * @return
     */
    @PostMapping("/{seckillId}/{md5}/execution")
    @ResponseBody
    public Result<SeckillExecution> execute(
            @PathVariable("seckillId") long seckillId,
            @PathVariable("md5") String md5,
            @CookieValue(value = "phone", required = false) long phone) {
        if (phone <= 0L) {
            return ResultUtil.error("未注册");
        }
        try {
            //SeckillExecution seckillExecution = seckillService.executeSeckill(seckillId, phone, md5);
            // 存储过程执行秒杀
            SeckillExecution seckillExecution = seckillService.executeSeckillProcedure(seckillId, phone, md5);
            return ResultUtil.success(seckillExecution);
        } catch (SeckillRepeatException sre) {
            return ResultUtil.error(SeckillStatEnum.REPEAT.getStateInfo());
        } catch (SeckillCloseException sce) {
            return ResultUtil.error(SeckillStatEnum.NOT_START.getStateInfo());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return ResultUtil.error(ResultCodeEnum.UNKNOW_ERROR);
        }
    }

    /**
     * 获取系统当前时间
     * @return
     */
    @GetMapping("/time/now")
    @ResponseBody
    public Result<Long> time() {
        return ResultUtil.success(new Date().getTime());
    }

}
