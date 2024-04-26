package com.example.orderdetails;

import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.exceptions.OrderNotFound;

@RestController
public class OrderDetailsController 
{
	@Autowired
	 private OrderDetailsService service;//ref variable
	 @Autowired
	 private OrderDetailsRepository repo;
	 
	 
	 @GetMapping("/orderdetails")    
	 public List<OrderDetails> list() 
	 {
	 return service.listAll();
	 }
	 
	 @GetMapping("/orderdetails/{id}")
	 public ResponseEntity<OrderDetails> get(@PathVariable Integer id) 
	 {
	 try
	 {
		 OrderDetails od = service.get(id);
		 return new ResponseEntity<OrderDetails>(od, HttpStatus.OK);
	 } 

	 catch(OrderNotFound ex)
	 {
		
		 return new ResponseEntity<OrderDetails>( HttpStatus.NOT_FOUND);
	 }
	 }
	 
	 //create or insert

	 @PostMapping("/orderdetails")
	 public void add(@RequestBody OrderDetails od) 
	 {
	 service.save(od);
	 }
	 
	 @PutMapping("/orderdetails/{id}")
	 public ResponseEntity<?> update(@RequestBody OrderDetails od, @PathVariable Integer id) 
	 {
	 try
	 {
		 OrderDetails existOrder = service.get(id);
	 service.save(od);
	 return new ResponseEntity<>(HttpStatus.OK);
	 } 
	 catch (NoSuchElementException e) 
	 {
	 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	 } 
	 }

	 @DeleteMapping("/orderdetails/{id}")
	 public void delete(@PathVariable Integer id) //extracting ID from the URL
	 {
	 service.delete(id);
	 }
	

}
