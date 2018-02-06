package com.test.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.test.project.mapper.EmployeeMapper;
import com.test.project.pojo.Employee;
import com.test.project.service.EmployeeService;

/**
 * 
 * @Description: 员工业务逻辑实现类
 * @author wang_dgang
 * @date 2017年2月23日 下午5:18:22
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

	// 注入mapper
	@Autowired
	private EmployeeMapper empDao;
	
	@Override
	public PageInfo<Employee> findAllEmployees(int pn, int ps) {
		PageHelper.startPage(pn, ps);
		List<Employee> list = empDao.findAll();
		PageInfo<Employee> pi = new PageInfo<Employee>(list);
		return pi;
	}

}
