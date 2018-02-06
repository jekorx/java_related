package com.util.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.pagehelper.PageInfo;
import com.test.project.pojo.Employee;
import com.test.project.service.EmployeeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class TestUtil {
	
	@Autowired
	private EmployeeService empService;
	
	@Test
	public void TestSpring() {
		PageInfo<Employee> page = empService.findAllEmployees(1, 10);
		System.out.println(page);
	}
}
