package com.pratik.job_authentication_service.repo;

import com.pratik.job_authentication_service.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserDto, Long> {
    Optional<UserDto> findByUsername(String username);
}
