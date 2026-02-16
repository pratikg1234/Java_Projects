package com.boot.jobboard.rest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.jobboard.rest.dvo.Application;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
}

