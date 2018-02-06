package com.test.project.util.bean;

import com.test.project.constants.Constants;

/**
 * 
 * @Description: 后台向前台返回的JSON对象
 * @author wang_dgang
 * @date 2017年3月2日 上午10:47:22
 *
 */
public class JsonBean {
	
	// 处理结果状态
	private String status = Constants.JSON_STATUS_OK;
	
	// 处理返回信息
	private String msg = null;
	
	// 主数据
	private Object data = null;
	
	// 其他数据
	private Object data2 = null;
	
	public JsonBean() {
		
	}
	
	/**
	 * 请求失败，返回信息
	 * @param msg
	 */
	public JsonBean(String msg) {
		this.msg = msg;
	}
	
	/**
	 * 返回信息，须注明状态
	 * @param result
	 * @param msg
	 */
	public JsonBean(String status, String msg) {
		this.status = status;
		this.msg = msg;
	}
	
	/**
	 * 请求成功，并添加数据
	 * @param data
	 */
	public JsonBean(Object data) {
		this.data = data;
		this.status = Constants.JSON_STATUS_OK;
	}
	
	/**
	 * 请求成功，并添加数据，和返回信息
	 * @param data
	 * @param msg
	 */
	public JsonBean(Object data, String msg) {
		this.data = data;
		this.msg = msg;
		this.status = Constants.JSON_STATUS_OK;
	}
	
	/**
	 * 请求成功，返回两个数据
	 * @param data
	 * @param data2
	 */
	public JsonBean(Object data, Object data2) {
		this.data = data;
		this.data2 = data2;
		this.status = Constants.JSON_STATUS_OK;
	}
	
	/**
	 * 请求成功，返回两个数据，并返回信息
	 * @param data
	 * @param data2
	 * @param msg
	 */
	public JsonBean(Object data, Object data2, String msg) {
		this.data = data;
		this.data2 = data2;
		this.status = Constants.JSON_STATUS_OK;
		this.status = Constants.JSON_STATUS_OK;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Object getData2() {
		return data2;
	}

	public void setData2(Object data2) {
		this.data2 = data2;
	}
	
}
