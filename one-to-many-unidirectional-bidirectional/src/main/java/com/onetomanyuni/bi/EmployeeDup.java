package com.onetomanyuni.bi;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class EmployeeDup {
	@Id
	private int empId;
	private String empName;
	@ManyToOne
	private DepartmentDup departmentDup;
	public EmployeeDup() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeDup(int empId, String empName) {
		super();
		this.empId = empId;
		this.empName = empName;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public DepartmentDup getDepartmentDup() {
		return departmentDup;
	}
	public void setDepartmentDup(DepartmentDup departmentDup) {
		this.departmentDup = departmentDup;
	}
	
}
