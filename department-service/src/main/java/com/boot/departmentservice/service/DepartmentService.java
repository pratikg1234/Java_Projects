package com.boot.departmentservice.service;

import org.springframework.stereotype.Service;

import com.boot.departmentservice.entity.Department;

@Service
public interface DepartmentService {
    Department saveDepartment(Department department);

    Department getDepartmentById(Long departmentId);
}