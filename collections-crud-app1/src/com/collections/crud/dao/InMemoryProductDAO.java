package com.collections.crud.dao;

import java.util.ArrayList;
import java.util.List;

import com.collections.crud.dvo.Product;
import com.collections.crud.exceptions.ProductNotFoundException;

public class InMemoryProductDAO implements productDAO{

	private List<Product> prodList = new ArrayList<>();
	@Override
	public void createProduct(Product product) {
		//actual code that inserts the product record into 
		//database like MySQL, in real world app.
		//but since we dont have database, in this method we are storing in collections
		prodList.add(product);
	}
	@Override
	public List<Product> findAll() {
		return prodList;
	}
	@Override
	public Product findById(int prodCode) throws ProductNotFoundException {
		Product temp = null;
		for(Product p : prodList) {
			if(p.getProdCode() == prodCode) {
				temp = p;
				break;
			}
		}
		if(temp == null) {
			throw new ProductNotFoundException(prodCode);
		}
		return temp;
	}
	@Override
	public void updateProduct(Product product) {
	int index = findIndex(product);
		if(index == -1) {
			System.out.println("No matching product found with product code.."+product.getProdCode());
		}
		prodList.set(index, product);
		System.out.println("Product updated...");
	}
	
	public int findIndex(Product product) {
		int index=-1;
		for(Product p : prodList) {
			if(p.getProdCode() == product.getProdCode()) {
				index = prodList.indexOf(p);
				break;
			}
		}
		return index;
	}
	@Override
	public void deleteProduct(Product product) {
		int index = findIndex(product);
		if(index !=-1) {
			prodList.remove(index);
			System.out.println("Product deleted...");
		}
		else {
			System.out.println("Product not found...");
		}
	}

}
