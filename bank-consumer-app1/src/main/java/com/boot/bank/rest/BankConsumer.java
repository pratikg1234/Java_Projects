package com.boot.bank.rest;


import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class BankConsumer {
	static String url = "http://localhost:8082/bank";
	static String urlWithParams = "http://localhost:8082/bank/{actNumber}";
	static RestTemplate template = new RestTemplate();
	
	public static void addRecord() {
		Bank p1 = new Bank(101,"customer-1",12000);
		Bank p2 = new Bank(102,"customer-2",100000);
		Bank p3 = new Bank(103,"customer-3",11300);
		Bank p4 = new Bank(104,"customer-4",15000);
		template.postForObject(url, p1, Bank.class);
		template.postForObject(url, p2, Bank.class);
		template.postForObject(url, p3, Bank.class);
		template.postForObject(url, p4, Bank.class);
		System.out.println("HTTP POST executed...");
	}
	
	public static void getAllBankAccounts() {
		Bank p[]=template.getForObject(url, Bank[].class);
		for(Bank temp:p) {
			System.out.println("actNumber: "+temp.getActNumber()+"customerName: "+temp.getCustomerName()+"actBalance: "+temp.getActBalance());
		}
	}
	
	public static void deleteBankAccount() {
//		Map<String, Integer> paramMap = new HashMap<>();
//		paramMap.put("actNumber", 101);
//		template.delete(urlWithParams,paramMap);
		
		try {
	        Map<String, Integer> paramMap = new HashMap<>();
	        paramMap.put("actNumber", 110);
	        template.delete(urlWithParams, paramMap);
	        System.out.println("Account deleted successfully.");
	    } catch (HttpClientErrorException | HttpServerErrorException ex) {
	        System.out.println("HTTP Error: " + ex.getStatusCode() + " - " + ex.getResponseBodyAsString());
	    } catch (RestClientException ex) {
	        System.out.println("Rest Client Error: " + ex.getMessage());
	    } catch (Exception ex) {
	        System.out.println("Unexpected Error: " + ex.getMessage());
	    }
	}
	
	
	public static void getBankAccountById() {
//		Map<String, Integer> paramMap = new HashMap<>();
//		paramMap.put("actNumber", 110);
//		ResponseEntity<Bank> entity = template.getForEntity(urlWithParams, Bank.class, paramMap);
//			MediaType mt = entity.getHeaders().getContentType();
//		System.out.println("Contet type= "+mt);
//		System.out.println("Status Code= "+entity.getStatusCode());
//		System.out.println(entity.getBody().getCustomerName());
		
		 try {
		        Map<String, Integer> paramMap = new HashMap<>();
		        paramMap.put("actNumber", 110);
		        ResponseEntity<Bank> entity = template.getForEntity(urlWithParams, Bank.class, paramMap);
		        
		        MediaType mt = entity.getHeaders().getContentType();
		        System.out.println("Content type = " + mt);
		        System.out.println("Status Code = " + entity.getStatusCode());
		        System.out.println(entity.getBody().getCustomerName());
		    } catch (HttpClientErrorException | HttpServerErrorException ex) {
		        System.out.println("HTTP Error: " + ex.getStatusCode() + " - " + ex.getResponseBodyAsString());
		    } catch (RestClientException ex) {
		        System.out.println("Rest Client Error: " + ex.getMessage());
		    } catch (Exception ex) {
		        System.out.println("Unexpected Error: " + ex.getMessage());
		}
	}
	
	public static void updateBankAccount() {
	    try {
	        int actNumber = 102;
	        Bank updatedBankAccount = new Bank(actNumber, "updated-customer-2", 15000);  
	
	        template.put(url, updatedBankAccount);
	        System.out.println("Account updated successfully.");
	    } catch (HttpClientErrorException | HttpServerErrorException ex) {
	        System.out.println("HTTP Error: " + ex.getStatusCode() + " - " + ex.getResponseBodyAsString());
	    } catch (RestClientException ex) {
	        System.out.println("Rest Client Error: " + ex.getMessage());
	    } catch (Exception ex) {
	        System.out.println("Unexpected Error: " + ex.getMessage());
	    }
	}

	public static void main(String[] args) {
//		getBankAccountById();
//		addRecord();
//		deleteBankAccount();
//		getAllBankAccounts();
//		updateBankAccount();
	}
}
