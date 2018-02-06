package com.test.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.test.project.pojo.Employee;
import com.test.project.service.EmployeeService;

/**
 * 
 * @Description: 员工控制器
 * @author wang_dgang
 * @date 2017年2月23日 下午5:16:31
 *
 */
@Controller
@RequestMapping("/emp")
public class EmployeeController {
	
	// 注入service
	@Autowired
	private EmployeeService empService;
	
	/**
	 * 页面跳转到index
	 * @return
	 */
	@RequestMapping(value="/getEmps/{pn}/{ps}", method = RequestMethod.GET)
	private ModelAndView getEmps(
			@PathVariable("pn") int pn,
			@PathVariable("ps") int ps) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		mv.addObject("pn", pn);
		mv.addObject("ps", ps);
		PageInfo<Employee> pi = empService.findAllEmployees(pn, ps);
		mv.addObject("page", pi);
		return mv;
	}
	
}
