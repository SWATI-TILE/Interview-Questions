package com.jpa.test.Controller;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.test.Entity.Employee;
import com.jpa.test.Service.EmployeeService;

@RestController
@EntityScan("com.jpa.test.Entity")
@CrossOrigin(origins = "*", allowedHeaders="*")
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	//save record
	@PostMapping("/SaveEmployee")
	public int saveEmployeeDetails(@RequestBody Employee e)
	{
		service.addEmployee(e);
		return 0;
	}
	
	//show all records
	@GetMapping("/Employees")
	public List<Employee> getAllEmplyeesRecords()
	{
		return service.getAllEmployeeRecords();
	}
	
	//show only one record using id
	@GetMapping("/Employee/{id}")
	public Employee getEmployeeRecord(@PathVariable int id)
	{
		Employee e1 = service.getEmployeeRecordById(id);
		return e1;
	}
	
	//delete only one record using id
	@DeleteMapping("/EmployeeDelete/{id}")
	public String deleteEmployeeRecord(@PathVariable int id)
	{
		return service.deleteEmployeeRecordById(id);
		
	}
	
	//update one record using id 
	@PutMapping("/EmployeeUpdate/{id}")
	public String updateEmplyeeRecord(@PathVariable int id,@RequestBody Employee e)
	{
		return service.updateEmployeeRecordById(id, e);
		
	}
	

}
