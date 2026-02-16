package com.onetomanyuni;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class OneToManyDepartementEmployeeUniMain1 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("test1");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		Department d1 = new Department();
		d1.setDeptId(1);
		d1.setDeptName("Sales");
		
		Employee e1 = new Employee(101,"Scott");
		Employee e2 = new Employee(102,"Smith");
		Employee e3 = new Employee(103,"Allen");
		
		d1.getEmpList().add(e1);
		d1.getEmpList().add(e2);
		d1.getEmpList().add(e3);
		
		et.begin();
		em.persist(d1);
		et.commit();
		System.out.println("Records Added In Unidirectional...");
	}
}
