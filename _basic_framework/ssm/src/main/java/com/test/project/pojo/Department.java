package com.test.project.pojo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 
 * @Description: 部门pojo
 * @author wang_dgang
 * @date 2017年3月1日 下午5:21:20
 *
 */
@Table(name = "department")
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "depid")
	private Integer depId;
	
	@Column(name = "depname")
	private String depName;
	
	@Transient
	private List<Employee> empList;

	public Integer getDepId() {
		return depId;
	}

	public void setDepId(Integer depId) {
		this.depId = depId;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public List<Employee> getEmpList() {
		return empList;
	}

	public void setEmpList(List<Employee> empList) {
		this.empList = empList;
	}
	
}
