package com.pratik.application_service.repository;


import com.pratik.application_service.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
	boolean existsByEmailAndJobId(String email, Long jobId);
	void deleteByIdAndJobId(Long id, Long jobId);
	List<Application> findByJobId(Long jobId);
}

