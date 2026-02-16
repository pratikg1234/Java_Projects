package com.boot.bank.rest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.bank.rest.dvo.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, Integer>{

}
