package com.bomapp.demo.query;

import com.bomapp.demo.model.Department;
import com.bomapp.demo.model.User;
import com.bomapp.demo.service.DepartmentService;
import com.bomapp.demo.service.UserService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DepartmentQuery implements GraphQLQueryResolver {

    private DepartmentService departmentService;

    public DepartmentQuery(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    public List<Department> getDepartments() {
        return this.departmentService.getAllDepartments();
    }

    public Optional<Department> getDepartment(int id) {
        return this.departmentService.getDepartment(id);
    }
}
