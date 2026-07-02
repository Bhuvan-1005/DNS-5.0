package com.deep.exercise1.controller;

import com.deep.exercise1.model.Employee;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final Map<Long, Employee> employeeStore = new HashMap<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    @GetMapping
    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employeeStore.values());
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeStore.get(id);
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        Long newId = idCounter.getAndIncrement();
        employee.setId(newId);
        employeeStore.put(newId, employee);
        return employee;
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        employee.setId(id);
        employeeStore.put(id, employee);
        return employee;
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeStore.remove(id);
        return "Employee with ID " + id + " deleted successfully";
    }
}
