package com.jpa.test.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.test.Entity.OrderDetails;
import com.jpa.test.Repository.OrderDetailsRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class OrderDetailsService {
	@Autowired
	OrderDetailsRepository repo;
	
	//save
		public OrderDetails addrecord(OrderDetails s) {
			
			return repo.save(s);
		}
		
		//Select all
		public List<OrderDetails> getAllOrderDetails() {
			return repo.findAll();
		}
		
		//Select ById
		public OrderDetails getOrderDetailsByid(int sid) {
			OrderDetails e = null;
			 try {
				Optional<OrderDetails> sitem =repo.findById(sid);
				 if(sitem.isPresent())
				 {
					 return sitem.get();
				 }
				
			 }
			 catch(NoSuchElementException excep)
			 {
				 System.out.println("No such record found");
			 }
			 
			 return e;
		}
		
		//Delete BYId
		public String deleterecord(int sid) {
			
			OrderDetails s = getOrderDetailsByid(sid);
			if(s==null)
			{
				return "Record is not found";
			}
			else
			{
			repo.deleteById(sid);
			return "Record is deleted";
			}
		} 
		
		//update
		public String updateOrderDetailsRecordById(int sid, OrderDetails e)
		{
			OrderDetails sitem = getOrderDetailsByid(sid);
			if(sitem == null)
			{
				return "OrderDetails record is not found for updation...";
			}
			else
			{
				repo.save(e);
				return "OrderDetails record is Updated";
			}
			
		}
		

}
