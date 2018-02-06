package com.test.project.mapper;

import java.util.List;

import com.test.project.pojo.Employee;

import tk.mybatis.mapper.common.Mapper;

/**
 * 
 * @Description: 员工数据接口
 * @author wang_dgang
 * @date 2017年3月1日 下午5:27:48
 *
 */
public interface EmployeeMapper extends Mapper<Employee> {
	
	/**
	 * 获取所有员工
	 * @return List<Employee>
	 */
	public List<Employee> findAll();
}
