package com.streams;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductStreamMain1 {
	public static void forEachDemo() {
		ProductData.prodList.stream()
					.forEach(System.out::println);
	}
	public static void findAndCollect() {
		//In this method we declare a few Integers which contain the prodCode
		//from those Integers we create a Stream
		//from that Stream we use map() & then input prodCode, using that input a productDup object
		//and return it from map, then produces a new intermediate stream
		//the intermediate stream contains all productDup objects which are searched
		
		
		Integer productCodes[]= {101,105,106,202,205,206};
		Stream.of(productCodes)
		//.map (here we need to provide
		.map(ProductData::findProduct)
		.collect(Collectors.toList())
		.forEach(p->System.out.println(p.getProdCode()+" "+p.getProdName()));
	}
	
	public static void findByPriceGreaterThan() {
		ProductData.prodList.stream()
		.filter(p->p.getPrice()>500)
		.collect(Collectors.toList())
		.forEach(p->System.out.println(p.getProdCode()+" "+p.getProdName()+" "+p.getPrice()));
	}
	
	public static void findByCategoryStationary() {
		ProductData.prodList.stream()
		.filter(p->p.getCategory().equals("stationary"))
		.collect(Collectors.toList())
		.forEach(p->System.out.println(p.getProdCode()+" "+p.getProdName()+" "+p.getPrice()+" "+p.getCategory()));
	}
	
	public static void increasePriceForMobilesBy100AndPrint() {
		ProductData.prodList.stream()
		.filter(p->p.getCategory().equals("Mobile phones"))
		.map(p->{
			ProductDup temp =new ProductDup();
			temp.setProdCode(p.getProdCode());
			temp.setCategory(p.getCategory());
			temp.setPrice(p.getPrice()+100);
			temp.setProdName(p.getProdName());
			temp.setQoh(p.getQoh());
			return temp;
		})
		.forEach(p -> {
            p.setPrice(p.getPrice() + 100);
            System.out.println(p.getProdCode() + " " + p.getProdName() + " " + p.getPrice());
      });
	}
	
	public static void findProductWithMaxPrice() {
		ProductData.prodList.stream()
		.max((p1,p2)->p1.getPrice()-p2.getPrice())
		.ifPresent(System.out::println);
	}
	
	public static void sortByProdName() {
		ProductData.prodList.stream()
		.sorted((p1,p2)->p1.getProdName().compareTo(p2.getProdName()))
		.collect(Collectors.toList())
		.forEach(System.out::println);
	}
	
	public static void priceSummary() {
		DoubleSummaryStatistics stats = ProductData.prodList.stream()
					.collect(Collectors.summarizingDouble(ProductDup::getPrice));
			System.out.println("Average= "+stats.getAverage());
			System.out.println("max="+stats.getMax());
		
	}
	public static void main(String[] args) {
//		forEachDemo();
//		findAndCollect();
//		findByPriceGreaterThan();
//		findByCategoryStationary();
//		increasePriceForMobilesBy100AndPrint();
//		findProductWithMaxPrice();
//		sortByProdName();
		priceSummary();
	}
}
