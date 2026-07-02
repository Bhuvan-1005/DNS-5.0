package com.example.service;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Page<Employee> getEmployeesPaginated(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    public List<Employee> getEmployeesSorted(Sort sort) {
        return employeeRepository.findAll(sort);
    }
}
