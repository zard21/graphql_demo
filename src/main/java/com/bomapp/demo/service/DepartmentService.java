package com.bomapp.demo.service;

import com.bomapp.demo.model.Department;
import com.bomapp.demo.model.User;
import com.bomapp.demo.repository.DepartmentRepository;
import com.bomapp.demo.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@Transactional
public class DepartmentService {

    private DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository db) {
        this.departmentRepository = db;
    }

    public List<Department> getAllDepartments() {
        return this.departmentRepository.findAll();
    }

    public Optional<Department> getDepartment(int id) {
        return this.departmentRepository.findById(id);
    }

    public List<Department> getDepartments() {
        return this.departmentRepository.findAll();
    }

    public Department createDepartment(String code, String name) {
        Department department = new Department();
        department.setCode(code);
        department.setName(name);

        return this.departmentRepository.save(department);
    }
}
