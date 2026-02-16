package com.onetomanyuni.bi;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class DepartmentDup {
	@Id
	private int deptId;
	private String deptName;
	
	//we can either use mapped by or join table
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "departmentDup")
	
	private List<EmployeeDup> empList = new ArrayList<>();
	public DepartmentDup() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DepartmentDup(int deptId, String deptName, List<EmployeeDup> empList) {
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
	public List<EmployeeDup> getEmpList() {
		return empList;
	}
	public void setEmpList(List<EmployeeDup> empList) {
		this.empList = empList;
	}
	
}
