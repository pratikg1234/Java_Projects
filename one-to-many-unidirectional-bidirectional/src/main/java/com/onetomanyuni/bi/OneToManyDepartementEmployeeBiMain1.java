package com.onetomanyuni.bi;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class OneToManyDepartementEmployeeBiMain1 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("test1");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		DepartmentDup d1 = new DepartmentDup();
		d1.setDeptId(1);
		d1.setDeptName("Sales");
		
		EmployeeDup e1 = new EmployeeDup(101,"Scott");
		EmployeeDup e2 = new EmployeeDup(102,"Smith");
		EmployeeDup e3 = new EmployeeDup(103,"Allen");
		
		d1.getEmpList().add(e1);
		d1.getEmpList().add(e2);
		d1.getEmpList().add(e3);
		
		e1.setDepartmentDup(d1);
		et.begin();
		em.persist(d1);
		et.commit();
		System.out.println("Records Added Using Bidirectional...");
	}
}
