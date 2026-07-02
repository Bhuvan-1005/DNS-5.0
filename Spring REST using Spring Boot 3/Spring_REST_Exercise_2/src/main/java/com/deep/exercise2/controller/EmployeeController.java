package com.deep.exercise2.controller;

import com.deep.exercise2.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final Map<Long, Employee> employeeStore = new HashMap<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(
            @RequestParam(required = false) String department,
            @RequestParam(required = false) String sortBy,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        List<Employee> result = new ArrayList<>(employeeStore.values());

        if (department != null && !department.isEmpty()) {
            result = result.stream()
                    .filter(e -> department.equalsIgnoreCase(e.getDepartment()))
                    .collect(Collectors.toList());
        }

        if ("salary".equalsIgnoreCase(sortBy)) {
            result.sort((a, b) -> Double.compare(
                    a.getSalary() != null ? a.getSalary() : 0,
                    b.getSalary() != null ? b.getSalary() : 0));
        } else if ("name".equalsIgnoreCase(sortBy)) {
            result.sort((a, b) -> a.getFirstName().compareToIgnoreCase(b.getFirstName()));
        }

        int start = Math.min(page * size, result.size());
        int end = Math.min(start + size, result.size());
        List<Employee> pagedResult = result.subList(start, end);

        return ResponseEntity.ok(pagedResult);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeStore.get(id);
        if (employee == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/department/{dept}/employee/{empId}")
    public ResponseEntity<Employee> getEmployeeByDeptAndId(
            @PathVariable("dept") String department,
            @PathVariable("empId") Long employeeId) {

        Employee employee = employeeStore.get(employeeId);
        if (employee == null || !department.equalsIgnoreCase(employee.getDepartment())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Employee>> searchEmployees(
            @RequestParam String keyword,
            @RequestParam(defaultValue = "false") boolean exactMatch) {

        List<Employee> results;

        if (exactMatch) {
            results = employeeStore.values().stream()
                    .filter(e -> keyword.equals(e.getFirstName()) || keyword.equals(e.getLastName()))
                    .collect(Collectors.toList());
        } else {
            String lowerKeyword = keyword.toLowerCase();
            results = employeeStore.values().stream()
                    .filter(e -> e.getFirstName().toLowerCase().contains(lowerKeyword)
                            || e.getLastName().toLowerCase().contains(lowerKeyword)
                            || e.getEmail().toLowerCase().contains(lowerKeyword))
                    .collect(Collectors.toList());
        }

        if (results.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(results);
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Long newId = idCounter.getAndIncrement();
        employee.setId(newId);
        employeeStore.put(newId, employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(employee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        if (!employeeStore.containsKey(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        employee.setId(id);
        employeeStore.put(id, employee);
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        if (!employeeStore.containsKey(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        employeeStore.remove(id);
        return ResponseEntity.noContent().build();
    }
}
