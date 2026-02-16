package com.boot.product.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.boot.product.rest.dvo.Product;
import com.boot.product.rest.service.ProductService;

@RestController  //@Controller + @ResponseBody
@RequestMapping("/api/v1/products")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@GetMapping
	public List<Product> findAll(){
		return service.findAll();
	}
	
	@PostMapping
	public Product add(@RequestBody Product product) {
		return service.save(product);
	}
	
	@PutMapping
	public Product update(@RequestBody Product product) {
		return service.save(product);
	}
	
	@DeleteMapping("/{prodId}")
	public void delete(@PathVariable("prodId")int prodId) {
		service.deleteById(prodId);
	}
	
	@GetMapping("/{prodId}")
	public Product findById(@PathVariable("prodId")int prodId) {
		return service.findById(prodId);
	}
}

//@Controller does following things internally
//It extends ProductController class with one of spring mvc in built classes
//e.g. AbstractController
//Second thing that annotation does is, it generates <bean> tag or @Bean method for
//declaring object of ProductController class as an bean in spring ApplicationContext


