package com.jpa.examples;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee_tble")
public class Employee {
	@Id  //this will marks prodCode as a column which will be mapped to prodCode PK column in the db table
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int empNumber;
	@Column
	private String empName;
	@Column
	private LocalDate doj;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int empNumber, String empName, LocalDate doj) {
		super();
		this.empNumber = empNumber;
		this.empName = empName;
		this.doj = doj;
	}
	public int getEmpNumber() {
		return empNumber;
	}
	public void setEmpNumber(int empNumber) {
		this.empNumber = empNumber;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public LocalDate getDoj() {
		return doj;
	}
	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}
	
}
