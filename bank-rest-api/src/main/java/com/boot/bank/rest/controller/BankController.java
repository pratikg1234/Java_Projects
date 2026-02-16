package com.boot.bank.rest.controller;

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

import com.boot.bank.rest.dvo.Bank;
import com.boot.bank.rest.service.BankService;

@RestController  //@Controller + @ResponseBody
@RequestMapping("/bank")
public class BankController {
	
	@Autowired
	private BankService service;
	
	@GetMapping
	public List<Bank> findAll(){
		return service.findAll();
	}
	
	@PostMapping
	public Bank add(@RequestBody Bank bank) {
		return service.save(bank);
	}
	
	@PutMapping
	public Bank update(@RequestBody Bank bank) {
		return service.save(bank);
	}
	
	@DeleteMapping("/{actNumber}")
	public void delete(@PathVariable("actNumber")int actNumber) {
		service.deleteById(actNumber);
	}
	
	@GetMapping("/{actNumber}")
	public Bank findById(@PathVariable("actNumber")int actNumber) {
		return service.findById(actNumber);
	}
}




