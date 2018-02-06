package com.ssm.enums;

/**
 * 秒杀状态枚举
 */
public enum SeckillStatEnum {
    FAILED(-1, "内部错误"),
    SUCCESS(0, "秒杀成功"),
    REPEAT(1, "重复秒杀"),
    NOT_START(2, "秒杀未开始"),
    ENDED(3, "秒杀结束"),
    REWRITE(4, "商品id被篡改"),
    ;

    private int state;

    private String stateInfo;

    SeckillStatEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static SeckillStatEnum stateOf(int state) {
        for (SeckillStatEnum se : values()) {
            if (se.getState() == state) {
                return se;
            }
        }
        return null;
    }
}
