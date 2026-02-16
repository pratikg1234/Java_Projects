package com.collections.crud.dao;

import java.util.List;

import com.collections.crud.dvo.Product;
import com.collections.crud.exceptions.ProductNotFoundException;

public interface productDAO {

	void createProduct(Product product);

	List<Product> findAll();

	Product findById(int prodCode) throws ProductNotFoundException;

	//to update a product, we have different options
	//1. get a product id, and a complete Product object to replace product object in Arraylist
	//2. get an entire Product object and replace it in array in ArrayList
	
	void updateProduct(Product product);
	void deleteProduct(Product product);
}
