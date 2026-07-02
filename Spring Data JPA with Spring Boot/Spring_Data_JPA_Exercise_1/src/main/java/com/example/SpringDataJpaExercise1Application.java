package com.example;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDataJpaExercise1Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaExercise1Application.class, args);
    }

    @Bean
    CommandLineRunner initData(EmployeeRepository repository) {
        return args -> {
            repository.save(new Employee("Eshwar", "Engineering", 85000.0));
            repository.save(new Employee("Priya", "Marketing", 72000.0));
            repository.save(new Employee("Ravi", "Engineering", 90000.0));
            repository.save(new Employee("Anita", "HR", 65000.0));
            repository.save(new Employee("Karthik", "Finance", 78000.0));

            System.out.println("===== All Employees =====");
            repository.findAll().forEach(System.out::println);
        };
    }
}
