package com.boot.product.rest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.product.rest.dvo.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
