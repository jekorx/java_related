package com.ssm.vo;

import com.ssm.enums.ResultCodeEnum;

public class Result<T> {

	// 状态码
	private int code;
	// 状态信息
	private String msg;
	// 返回值
	private T data;

	public Result() {
	}

	public Result(ResultCodeEnum resultCodeEnum) {
		this.code = resultCodeEnum.getCode();
		this.msg = resultCodeEnum.getMsg();
	}

	public Result(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public Result(ResultCodeEnum resultCodeEnum, T data) {
		this.code = resultCodeEnum.getCode();
		this.msg = resultCodeEnum.getMsg();
		this.data = data;
	}

	public Result(int code, String msg, T data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
