package com.employee.CRUDRestApi.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DataBaseRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByEmail(String email);
}
