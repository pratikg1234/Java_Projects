package com.spring.data.jpa.ex1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProductMain1 {
	static ProductService ps = null;
	static ApplicationContext ctx= null; //container
	public static void main(String[] args) {
		ctx = new AnnotationConfigApplicationContext(JpaConfig1.class);
//		addRecords();
//		updateRecord();
//		findById(101);
//		deleteById(104);
		findAll();
	}
	public static void addRecords() {
		ps = ctx.getBean(ProductService.class);
		ps.addOrUpdateProduct(new Product(101,"Product-101",110,"category-a"));
		ps.addOrUpdateProduct(new Product(102,"Product-102",190,"category-b"));
		ps.addOrUpdateProduct(new Product(103,"Product-103",150,"category-c"));
		ps.addOrUpdateProduct(new Product(104,"Product-104",510,"category-d"));
		ps.addOrUpdateProduct(new Product(105,"Product-105",140,"category-e"));
		ps.addOrUpdateProduct(new Product(106,"Product-106",190,"category-f"));
		ps.addOrUpdateProduct(new Product(107,"Product-107",200,"category-g"));
	}
	
	public static void updateRecord() {
		ps = ctx.getBean(ProductService.class);
        ps.updateProductName(107, "updated- product - 107");
    }
 
    public static void findById(int id) {
    	ps = ctx.getBean(ProductService.class);
        ps.findProductById(id);
    }
 
    public static void deleteById(int id) {
    	ps = ctx.getBean(ProductService.class);
        ps.deleteProductById(id);
    }
 
    public static void findAll() {
    	ps = ctx.getBean(ProductService.class);
        ps.findAllProducts();
    }
}
