package com.ssm.enums;

/**
 * 枚举：返回码-->返回信息
 * @author wang_donggang
 */
public enum ResultCodeEnum {

    UNKNOW_ERROR(-1, "未知错误"),
    SUCCESS(0, "请求成功"),
    FAILED(1, "请求失败"),
    ;

    // 状态码
    private int code;
    // 返回信息
    private String msg;

    private ResultCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
