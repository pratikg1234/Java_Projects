package com.boot.product.rest;


import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ProductConsumer {
	static String url = "http://localhost:8081/api/v1/products";
	static String urlWithParams = "http://localhost:8081/api/v1/products/{prodId}";
	static RestTemplate template = new RestTemplate();
	
	public static void addRecord() {
		Product p1 = new Product(101,"Product-101",120);
		Product p2 = new Product(102,"Product-102",100);
		Product p3 = new Product(103,"Product-103",130);
		Product p4 = new Product(104,"Product-104",150);
		template.postForObject(url, p1, Product.class);
		template.postForObject(url, p2, Product.class);
		template.postForObject(url, p3, Product.class);
		template.postForObject(url, p4, Product.class);
		System.out.println("HTTP POST executed...");
	}
	
	public static void getAllProducts() {
		Product p[]=template.getForObject(url, Product[].class);
		for(Product temp:p) {
			System.out.println(temp.getProdName());
		}
	}
	
	public static void deleteProduct() {
		Map<String, Integer> paramMap = new HashMap<>();
		paramMap.put("prodId", 101);
		template.delete(urlWithParams,paramMap);
	}
	
	
	public static void getProductById() {
		Map<String, Integer> paramMap = new HashMap<>();
		paramMap.put("prodId", 102);
		ResponseEntity<Product> entity = template.getForEntity(urlWithParams, Product.class, paramMap);
			MediaType mt = entity.getHeaders().getContentType();
		System.out.println("Contet type= "+mt);
		System.out.println("Status Code= "+entity.getStatusCode());
		System.out.println(entity.getBody().getProdName());
	}
	public static void main(String[] args) {
		getProductById();
//		addRecord();
//		deleteProduct();
//		getAllProducts();
	}
}
