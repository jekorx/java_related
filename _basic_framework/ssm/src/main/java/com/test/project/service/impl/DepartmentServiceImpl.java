package com.test.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.test.project.mapper.DepartmentMapper;
import com.test.project.pojo.Department;
import com.test.project.service.DepartmentService;

/**
 * 
 * @Description: 部门业务逻辑实现
 * @author wang_dgang
 * @date 2017年3月2日 上午9:35:20
 *
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	// 注入mapper
	@Autowired
	private DepartmentMapper depDao;

	@Override
	public PageInfo<Department> findAllDepartments(int pn, int ps) {
		PageHelper.startPage(pn, ps);
		List<Department> list = depDao.selectAll();
		PageInfo<Department> pi = new PageInfo<Department>(list);
		return pi;
	}
	
}
