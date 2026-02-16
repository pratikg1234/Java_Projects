package com.boot.userservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.userservice.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
