package com.spring.data.jpa.ex2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
	@Autowired
	private MovieRepository repo;
	
	public void addOrUpdateProduct(Movie p) {
		repo.save(p);
		System.out.println("Record added or updated...");
	}
}
