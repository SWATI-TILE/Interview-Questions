package com.jpa.test.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.test.Entity.Customer;
import com.jpa.test.Repository.CustomerRepository;


@Service
@Transactional
public class CustomerService {
	
	@Autowired
	CustomerRepository repo;
	
	public Customer addCustomer(Customer c)
	{
		return repo.save(c);
	}
	
	public List<Customer> getAllCustomerRecords()
	{
		return repo.findAll();
	}
	
	public Customer getCustomerRecordById(int cid)
	{
		 Customer c = null;
		 try {
			 Optional<Customer> cst =repo.findById(cid);
			 if(cst.isPresent())
			 {
				 return cst.get();
			 }
			
		 }
		 catch(NoSuchElementException excep)
		 {
			 System.out.println("No such record found");
		 }
		 
		 return c;
	}
	
	public String deleteCustomerRecordById(int cid)
	{
		Customer c = getCustomerRecordById(cid);
		if(c==null)
		{
			return "Record is not found";
		}
		else
		{
		repo.deleteById(cid);
		return "Record is deleted";
		}
	}
	
	public String updateCustomerRecordById(int cid, Customer c)
	{
		Customer cst = getCustomerRecordById(cid);
		if(cst == null)
		{
			return "Customer record is not found for updation...";
		}
		else
		{
			repo.save(c);
			return "Customer record is Updated";
		}
		
	}
	
	
	

}
