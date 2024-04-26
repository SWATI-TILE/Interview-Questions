package com.example.productdetails;

import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.example.exceptions.ProductNotFound;

@RestController

@CrossOrigin(origins="*")
public class ProductDetailsController 
{//DEPENDENCY INJECTION USING AUTOWIRING
 @Autowired
 private ProductDetailsService service;//reference variable
 @Autowired
 private ProductDetailsRepository repo;
 
 
 // RESTful API methods for Retrieval operations
 @GetMapping("/products")     
 public List<ProductDetails> list() 
 {
 return service.listAll();
 }
 
 @GetMapping("/products/{id}")
 public ResponseEntity<ProductDetails> get(@PathVariable Integer id) 
 {
 try
 {
 ProductDetails product = service.get(id);
 return new ResponseEntity<ProductDetails>(product, HttpStatus.OK);
 } 

 catch(ProductNotFound ex)
 {
	
	 return new ResponseEntity<ProductDetails>( HttpStatus.NOT_FOUND);
 }
 }
 
 //create or insert

 @PostMapping("/products")
 public void add(@RequestBody ProductDetails product) 
 {
 service.save(product);
 }
 
 

 @PutMapping("/products/{id}")
 public ResponseEntity<?> update(@RequestBody ProductDetails product, @PathVariable Integer id) 
 {
 try
 {
 ProductDetails existProduct = service.get(id);
 service.save(product);
 return new ResponseEntity<>(HttpStatus.OK);
 } 
 catch (NoSuchElementException e) 
 {
 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
 } 
 }

 @DeleteMapping("/products/{id}")
 public void delete(@PathVariable Integer id) //extracting ID from the URL
 {
 service.delete(id);
 }
}
