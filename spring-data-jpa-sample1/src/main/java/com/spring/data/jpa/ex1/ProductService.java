package com.spring.data.jpa.ex1;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	@Autowired
	private ProductRepository repo;
	
	public void addOrUpdateProduct(Product p) {
		repo.save(p);
		System.out.println("Record added or updated...");
	}
	
	public void updateProductName(int prodCode, String newName) {
        Optional<Product> product = repo.findById(prodCode);
//        if (product.isPresent()) {
//            Product p = product.get();
//            p.setProdName(newName);
//            repo.save(p);
//            System.out.println("Updated product name for code " + prodCode);
//        } else {
//            System.out.println("Product not found for update");
//        }
        
        product.ifPresentOrElse(
        		p->{p.setProdName(newName); System.out.println("Updated product name for code");}, 
        		()-> System.out.println("Product not found for update"));
    }
 
    public void findProductById(int prodCode) {
    	//this is best way of doing using optional
        Optional<Product> product = repo.findById(prodCode);
        product.ifPresentOrElse(
            p -> System.out.println("Found: " + p),
            () -> System.out.println("Product not found with code " + prodCode)
        );
//        
        
    }
 
    public void deleteProductById(int prodCode) {
        if (repo.existsById(prodCode)) {
            repo.deleteById(prodCode);
            System.out.println("Deleted product with code " + prodCode);
        } else {
            System.out.println("No product found to delete with code " + prodCode);
        }
    }
 
    public void findAllProducts() {
        List<Product> all = repo.findAll();
//        all.forEach(System.out::println);
        for(Product p : all) {
        	System.out.println(p.getProdName()+" "+p.getProdCode()+" "+p.getPrice()+" "+p.getCategory());
        }
    }
	
}
