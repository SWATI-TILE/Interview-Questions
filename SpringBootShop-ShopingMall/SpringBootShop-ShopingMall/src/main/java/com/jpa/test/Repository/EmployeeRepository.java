package com.jpa.test.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.test.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	

}
