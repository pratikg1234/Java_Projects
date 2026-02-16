package com.collections.crud.main;
import java.util.List;
import com.collections.crud.dvo.Product;
import com.collections.crud.exceptions.ProductNotFoundException;
import com.collections.crud.service.InMemoryProductService;
import com.collections.crud.service.ProductService;

public class ProductCRUDMain {
	public static ProductService ps = new InMemoryProductService();
	public static void main(String[] args) {
		createProduct();
		System.out.println("Fetching product before updating product..");
		fetchProducts();
		System.out.println("Now updating one product... and fetching product...");
		updateProduct();
		fetchProducts();
		deleteProduct();
		fetchProducts();
//		findById();
		
	}
	public static void createProduct() {
		ps.createProduct(new Product(1222,"S24",3000));
		ps.createProduct(new Product(1223,"S25",3000));
		ps.createProduct(new Product(1224,"S25",3600));
	}
	public static void fetchProducts() {
		List<Product> prodList = ps.findAll();
		for(Product p : prodList) {
			System.out.println(p.getProdCode()+p.getProdName()+p.getPrice());
		}
	}
	public static void findById() {
		Product find =null;
		try {
			find=ps.findById(222);
		} catch (ProductNotFoundException e) {
			System.out.println("product not found exceptionoccured..."+e);
		}
		System.out.println("product found--->"+ find.getProdName());
	}
	
	public static void updateProduct() {
		ps.updateProduct(new Product(1224,"Iphone 16 pro max",3700));
	}
	
	public static void deleteProduct() {
		ps.deleteProduct(new Product(1222,"S24",3000));
	}
}
