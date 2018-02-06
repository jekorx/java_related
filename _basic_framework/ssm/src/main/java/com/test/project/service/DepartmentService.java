package com.test.project.service;

import com.github.pagehelper.PageInfo;
import com.test.project.pojo.Department;

/**
 * 
 * @Description: 部门业务逻辑接口
 * @author wang_dgang
 * @date 2017年3月2日 上午9:31:40
 *
 */
public interface DepartmentService {
	
	/**
	 * 获取所有部门
	 * @return List<Department>
	 */
	public PageInfo<Department> findAllDepartments(int pn, int ps);
}
