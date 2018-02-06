package com.test.project.mapper;

import com.test.project.pojo.Department;

import tk.mybatis.mapper.common.Mapper;

/**
 * 
 * @Description: 部门数据接口
 * @author wang_dgang
 * @date 2017年3月1日 下午5:26:20
 *
 */
public interface DepartmentMapper extends Mapper<Department> {
	
	/**
	 * 获取所有部门
	 * @return List<Department>
	 */
	//public List<Department> findAll();
}
