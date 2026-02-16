package com.jpa.examples;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class jpaExampleMain2 {
	static EntityManagerFactory emf =null;
	static EntityManager em = null;
	static EntityTransaction et = null;
	
	public static void main(String[] args) {
		addRecord();
	}
	
	public static void addRecord() {

		//create an instance of EntityManagerFactory
		// test1 is the name of persistence-unit
		emf = Persistence.createEntityManagerFactory("test1");
		
		//using emf create an EntityManager instance em
		em = emf.createEntityManager();
		
		Employee e = new Employee();
		e.setEmpName("Pratik");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		e.setDoj(LocalDate.parse("21-04-2025", formatter));
		
		et = em.getTransaction();
		et.begin();//Transaction begin
			em.persist(e);//after transaction begin & before transaction end is called Transaction Boundary
		et.commit();
		System.out.println("Record Added Successfuly...");
	}

}