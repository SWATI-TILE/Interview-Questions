package com.jpa.test.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.test.Entity.Employee;
import com.jpa.test.Repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeService {
	
	@Autowired
	EmployeeRepository repo;
	
	public Employee addEmployee(Employee e)
	{
		return repo.save(e);
	}
	
	public List<Employee> getAllEmployeeRecords()
	{
		return repo.findAll();
	}
	
	public Employee getEmployeeRecordById(int eid)
	{
		 Employee e = null;
		 try {
			 Optional<Employee> emp =repo.findById(eid);
			 if(emp.isPresent())
			 {
				 return emp.get();
			 }
			
		 }
		 catch(NoSuchElementException excep)
		 {
			 System.out.println("No such record found");
		 }
		 
		 return e;
	}
	
	public String deleteEmployeeRecordById(int eid)
	{
		Employee e = getEmployeeRecordById(eid);
		if(e==null)
		{
			return "Record is not found";
		}
		else
		{
		repo.deleteById(eid);
		return "Record is deleted";
		}
	}
	
	public String updateEmployeeRecordById(int eid, Employee e)
	{
		Employee emp = getEmployeeRecordById(eid);
		if(emp == null)
		{
			return "Employee record is not found for updation...";
		}
		else
		{
			repo.save(e);
			return "Employee record is Updated";
		}
		
	}
	
	
	

}
 