package com.example;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDataJpaExercise4Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaExercise4Application.class, args);
    }

    @Bean
    CommandLineRunner initData(EmployeeRepository repository) {
        return args -> {
            repository.save(new Employee("Eshwar", "Engineering", 85000.0));
            repository.save(new Employee("Priya", "Marketing", 72000.0));
            repository.save(new Employee("Ravi", "Engineering", 90000.0));
            repository.save(new Employee("Anita", "HR", 65000.0));
            repository.save(new Employee("Karthik", "Finance", 78000.0));
            repository.save(new Employee("Deepa", "Engineering", 92000.0));
            repository.save(new Employee("Suresh", "Marketing", 68000.0));
            repository.save(new Employee("Meena", "HR", 71000.0));
            repository.save(new Employee("Arun", "Finance", 83000.0));
            repository.save(new Employee("Lakshmi", "Engineering", 95000.0));

            System.out.println("===== Seeded 10 Employees =====");
            System.out.println("Try: http://localhost:8080/api/employees/paginated?page=0&size=3&sortBy=salary&direction=desc");
            System.out.println("Try: http://localhost:8080/api/employees/sorted?sortBy=name&direction=asc");
        };
    }
}
