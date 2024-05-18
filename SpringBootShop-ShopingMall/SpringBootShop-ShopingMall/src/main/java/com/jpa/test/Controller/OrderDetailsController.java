package com.jpa.test.Controller;

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

import com.jpa.test.Entity.OrderDetails;
import com.jpa.test.Service.OrderDetailsService;

@RestController
@EntityScan("com.jpa.test.Entity")
@CrossOrigin(origins = "*", allowedHeaders="*")
public class OrderDetailsController {
	
	@Autowired
	OrderDetailsService service;
	
	//save
			@PostMapping("/SaveOrderDetails")
			public OrderDetails saveOrderDetails(@RequestBody OrderDetails s) {		
				service.addrecord(s);
				return s;
			}
			
			
			//show all record
			@GetMapping("/OrderDetailss")
			public List<OrderDetails> getAllOrderDetails()
			{
				return service.getAllOrderDetails();
			}
			
			
			@GetMapping("/OrderDetails/{id}")
			public OrderDetails getOrderDetails(@PathVariable int id) {
				
				OrderDetails s1 = service.getOrderDetailsByid(id) ;
				return s1;
			}
			
			@DeleteMapping("/DeleteOrderDetails/{id}")
			public String deleterecord(@PathVariable int id) {
				
				return service.deleterecord(id) ;
				
			}
			
			@PutMapping("UpdateOrderDetails/{id}")
			public String putMethodName(@PathVariable int id, @RequestBody OrderDetails s) {
				
				
				return service.updateOrderDetailsRecordById(id, s);
			}

}
