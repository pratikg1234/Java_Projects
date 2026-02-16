package com.onetomanyuni;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Department {
	@Id
	private int deptId;
	private String deptName;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "deptId") //if we dont declare this annotation, the code stills works
	//but one more extra table is created
	private List<Employee> empList = new ArrayList<>();
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Department(int deptId, String deptName, List<Employee> empList) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.empList = empList;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public List<Employee> getEmpList() {
		return empList;
	}
	public void setEmpList(List<Employee> empList) {
		this.empList = empList;
	}
	
}
