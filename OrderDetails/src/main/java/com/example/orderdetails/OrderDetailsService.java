package com.example.orderdetails;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class OrderDetailsService 
{
	@Autowired
	 private OrderDetailsRepository repo;// no new operator
	 
	 public List<OrderDetails> listAll() //RETRIEVE
	 {
		 return repo.findAll();
	 }
	 
	 public void save(OrderDetails od) //CREATE OR INSERT
	 {
		  repo.save(od);
	 }
	 
	 public OrderDetails get(Integer id) //RETRIEVE ON THE BASIS OF ID
	 {
		 return repo.findById(id).get();
	 }
	 
	 public void delete(Integer id) 
	 {
		 repo.deleteById(id);
	 }
	

}
