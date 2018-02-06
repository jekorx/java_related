package com.test.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.test.project.constants.Constants;
import com.test.project.pojo.Department;
import com.test.project.service.DepartmentService;
import com.test.project.util.bean.JsonBean;

/**
 * 
 * @Description: 部门控制器
 * @author wang_dgang
 * @date 2017年3月2日 上午9:30:11
 *
 */
@Controller
@RequestMapping("/dep")
public class DepartmentController {
	
	// 注入service
	@Autowired
	private DepartmentService depService;
	
	@RequestMapping(value = "/getAllDeps/{pn}/{ps}", produces = "application/json; charset=utf-8")
	@ResponseBody
	private JsonBean getAllDeps(
			@PathVariable("pn") int pn,
			@PathVariable("ps") int ps) {
		PageInfo<Department> pi = depService.findAllDepartments(pn, ps);
		JsonBean jsonBean = new JsonBean(pi, Constants.JSON_MSG_QUERY_OK);
		return jsonBean;
	}
}
