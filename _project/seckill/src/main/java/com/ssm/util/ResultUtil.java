package com.ssm.util;

import com.ssm.enums.ResultCodeEnum;
import com.ssm.vo.Result;

/**
 * 返回值包装工具类
 * @author wang_donggang
 */
public class ResultUtil {

    /**
     * 请求成功
     * @param object
     * @return
     */
    public static <T> Result<T> success() {
        return new Result<T>(ResultCodeEnum.SUCCESS);
    }
    /**
     * 请求成功
     * @param object
     * @return
     */
    public static <T> Result<T> success(T object) {
        return new Result<T>(ResultCodeEnum.SUCCESS, object);
    }
    /**
     * 请求失败
     * @param code
     * @param msg
     * @return
     */
    public static <T> Result<T> error(int code, String msg) {
        return new Result<T>(code, msg);
    }
    /**
     * 请求失败
     * @return
     */
    public static <T> Result<T> error() {
        return new Result<T>(ResultCodeEnum.FAILED);
    }
    /**
     * 请求失败
     * @param ResultCodeEnum
     * @return
     */
    public static <T> Result<T> error(ResultCodeEnum resultCodeEnum) {
        return new Result<T>(resultCodeEnum);
    }
    /**
     * 请求失败
     * @param msg
     * @return
     */
    public static <T> Result<T> error(String msg) {
        return new Result<T>(ResultCodeEnum.FAILED.getCode(), msg);
    }
    
}
