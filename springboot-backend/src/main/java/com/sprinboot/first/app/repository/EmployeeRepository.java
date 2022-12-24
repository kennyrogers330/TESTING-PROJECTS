package com.sprinboot.first.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprinboot.first.app.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
