package com.collections.crud.service;

import java.util.List;

import com.collections.crud.dao.InMemoryProductDAO;
import com.collections.crud.dao.productDAO;
import com.collections.crud.dvo.Product;
import com.collections.crud.exceptions.ProductNotFoundException;

public class InMemoryProductService implements ProductService {
	private productDAO dao = new InMemoryProductDAO();

	public void createProduct(Product product) {
		dao.createProduct(product);
	}

	@Override
	public List<Product> findAll() {
		return dao.findAll();
	}

	@Override
	public Product findById(int prodCode) throws ProductNotFoundException {
		return dao.findById(prodCode);
	}

	@Override
	public void updateProduct(Product product) {
		dao.updateProduct(product);
	}

	@Override
	public void deleteProduct(Product product) {
		dao.deleteProduct(product);
	}
}
