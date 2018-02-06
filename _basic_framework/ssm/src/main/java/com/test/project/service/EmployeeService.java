package com.test.project.service;

import com.github.pagehelper.PageInfo;
import com.test.project.pojo.Employee;

/**
 * 
 * @Description: 员工业务逻辑接口
 * @author wang_dgang
 * @date 2017年2月23日 下午5:17:29
 *
 */
public interface EmployeeService {
	
	/**
	 * 获取所有用户
	 * @return PageInfo<Employee>
	 */
	public PageInfo<Employee> findAllEmployees(int pn, int ps);
	
}
