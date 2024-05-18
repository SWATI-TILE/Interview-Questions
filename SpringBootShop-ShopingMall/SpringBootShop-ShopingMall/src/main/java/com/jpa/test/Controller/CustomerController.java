package com.jpa.test.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.test.Entity.Customer;
import com.jpa.test.Service.CustomerService;



@RestController
@CrossOrigin(origins = "*", allowedHeaders="*")
public class CustomerController {
	
	
	@Autowired
	CustomerService service;
	
	//save record
	@PostMapping("/SaveCustomer")
	public int saveCustomerDetails(@RequestBody Customer c)
	{
		
		service.addCustomer(c);
		return 0;
	}
	
	//show all records
		@GetMapping("/Customers")
		public List<Customer> getAllCustomerDetails()
		{
			return service.getAllCustomerRecords();
		}
		
		//show only one record using id
		@GetMapping("/Customer/{id}")
		public Customer getCustomerRecord(@PathVariable int id)
		{
			Customer c1 = service.getCustomerRecordById(id);
			return c1;
		}
		
		//delete only one record using id
		@DeleteMapping("/CustomerDelete/{id}")
		public String CustomerRecord(@PathVariable int id)
		{
			return service.deleteCustomerRecordById(id);
			
		}
		
		//update one record using id 
		@PutMapping("/CustomerUpdate/{id}")
		public String updateCustomerRecord(@PathVariable int id,@RequestBody Customer c)
		{
			return service.updateCustomerRecordById(id, c);
			
		}

}
