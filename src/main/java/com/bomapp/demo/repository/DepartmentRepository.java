package com.bomapp.demo.repository;

import com.bomapp.demo.model.Department;
import com.bomapp.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
