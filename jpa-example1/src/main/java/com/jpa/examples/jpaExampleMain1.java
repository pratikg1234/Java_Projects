package com.jpa.examples;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class jpaExampleMain1 {
	static EntityManagerFactory emf =null;
	static EntityManager em = null;
	static EntityTransaction et = null;
	
	public static void main(String[] args) {
//		addRecord();
//		addRecord();
//		updateRecord();
//		deleteRecord();
		fetchAll();
	}
	
	public static void fetchAll() {
		emf = Persistence.createEntityManagerFactory("test1");
		em = emf.createEntityManager();
		Query q1=em.createQuery("SELECT p FROM com.jpa.examples.Product as p");
		List<Product> prodList = q1.getResultList();
		for(Product p : prodList) {
			System.out.println(p.getProdCode()+" "+p.getProdName()+" "+p.getPrice());
		}
		
	}
	public static void addRecord() {

		//create an instance of EntityManagerFactory
		// test1 is the name of persistence-unit
		emf = Persistence.createEntityManagerFactory("test1");
		
		//using emf create an EntityManager instance em
		em = emf.createEntityManager();
		
		Product p = new Product();
		p.setProdName("S25");
		p.setPrice(3200.00);
		
		et = em.getTransaction();
		et.begin();//Transaction begin
			em.persist(p);//after transaction begin & before transaction end is called Transaction Boundary
		et.commit();
		System.out.println("Record Added Successfuly...");
	}

	public static void updateRecord() {
		//create an instance of EntityManagerFactory
		// test1 is the name of persistence-unit
			emf = Persistence.createEntityManagerFactory("test1");
				
		//using emf create an EntityManager instance em
			em = emf.createEntityManager();
				
			Product p1 =em.find(Product.class, 52);
			p1.setProdName("HELLO");
			p1.setPrice(4000.00);
			em.getTransaction().begin();
			em.persist(p1);
			em.getTransaction().commit();
			System.out.println("Record Updated Successfuly...");
	}

	public static void deleteRecord() {
		emf = Persistence.createEntityManagerFactory("test1");
		
		//using emf create an EntityManager instance em
			em = emf.createEntityManager();
				
			Product p1 =em.find(Product.class, 1);
			em.getTransaction().begin();
			em.remove(p1);
			em.getTransaction().commit();
			System.out.println("Record Deleted");
	}
}
