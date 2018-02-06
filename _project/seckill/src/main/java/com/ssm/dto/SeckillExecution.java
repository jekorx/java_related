package com.ssm.dto;

import com.ssm.entity.SuccKilled;
import com.ssm.enums.SeckillStatEnum;

/**
 * 封装秒杀成功后返回结果
 */
public class SeckillExecution {

    // 秒杀商品id
    private long seckillId;
    // 状态
    private int state;
    // 状态信息
    private String stateInfo;
    // 秒杀成功对象
    private SuccKilled succKilled;

    public SeckillExecution(long seckillId, SeckillStatEnum seckillStatEnum) {
        this.seckillId = seckillId;
        this.state = seckillStatEnum.getState();
        this.stateInfo = seckillStatEnum.getStateInfo();
    }

    public SeckillExecution(long seckillId, SeckillStatEnum seckillStatEnum, SuccKilled succKilled) {
        this.seckillId = seckillId;
        this.state = seckillStatEnum.getState();
        this.stateInfo = seckillStatEnum.getStateInfo();
        this.succKilled = succKilled;
    }

    public long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public SuccKilled getSuccKilled() {
        return succKilled;
    }

    public void setSuccKilled(SuccKilled succKilled) {
        this.succKilled = succKilled;
    }

    @Override
    public String toString() {
        return "SeckillExecution{" +
                "seckillId=" + seckillId +
                ", state=" + state +
                ", stateInfo='" + stateInfo + '\'' +
                ", succKilled=" + succKilled +
                '}';
    }
}
