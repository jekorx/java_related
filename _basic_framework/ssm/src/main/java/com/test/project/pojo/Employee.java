package com.test.project.pojo;

import javax.persistence.*;

/**
 * 
 * @Description: 员工pojo
 * @author wang_dgang
 * @date 2017年2月23日 下午5:10:43
 *
 */
@Table(name = "employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "empid")
	private Integer empId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "sex")
	private String sex;
	
	@Column(name = "age")
	private String age;
	
	@Transient
	private Department department;

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
}
