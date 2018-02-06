package com.spring.boot.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

/**
 * 人员表实体类
 * @author wang_donggang
 */
@Entity
public class Person implements Serializable {
	
	private static final long serialVersionUID = -6907477459011552338L;
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	@Min(value = 18, message = "未满18周岁")
	private int age;
	private String sex;
	public Person() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}
}
