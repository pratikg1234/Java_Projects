package com.boot.bank.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.bank.rest.dvo.Bank;
import com.boot.bank.rest.exception.BankAccountNotFoundException;
import com.boot.bank.rest.repo.BankRepository;

@Service
public class BankService {
	@Autowired
	private BankRepository repo;
	
	public Bank save(Bank product) {
		return repo.save(product);
	}
	
	public List<Bank> findAll(){
		return repo.findAll();
	}
	
	 public void deleteById(int actNumber) {
	    if(!repo.existsById(actNumber)) {
	            throw new BankAccountNotFoundException("Account number " + actNumber + " not found for deletion");
	    }
	    repo.deleteById(actNumber);
	 }
	    
	 public Bank findById(int actNumber) {
	    return repo.findById(actNumber)
	                   .orElseThrow(() -> new BankAccountNotFoundException("Account number " + actNumber + " not found"));
	 }
	
}

