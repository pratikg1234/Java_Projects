package com.boot.jobboardlite.rest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.jobboardlite.rest.dvo.Application;

import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
	boolean existsByEmailAndJobId(String email, Long jobId);
	List<Application> findByJobId(Long jobId);
	void deleteByIdAndJobId(Long id, Long jobId);
}

