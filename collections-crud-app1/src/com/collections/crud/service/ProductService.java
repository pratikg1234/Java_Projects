package com.collections.crud.service;

import java.util.List;

import com.collections.crud.dvo.Product;
import com.collections.crud.exceptions.ProductNotFoundException;

public interface ProductService {

	void createProduct(Product product);

	List<Product> findAll();

	Product findById(int prodCode) throws ProductNotFoundException;
	
	void updateProduct(Product product);

	void deleteProduct(Product product);
}
