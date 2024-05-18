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

import com.jpa.test.Entity.ShopEntity;
import com.jpa.test.Service.ShopService;

@RestController
@EntityScan("com.example.Entity")
@CrossOrigin(origins = "*", allowedHeaders="*")
public class ShopController {
	
	@Autowired
	ShopService service;
	
	//save
	@PostMapping("/SaveShop")
	public ShopEntity saveShop(@RequestBody ShopEntity s) {		
		service.addrecord(s);
		return s;
	}
	
	
	//show all record
	@GetMapping("/Shops")
	public List<ShopEntity> getAllshop()
	{
		return service.getAllshop();
	}
	
	
	@GetMapping("/Shop/{id}")
	public ShopEntity getShop(@PathVariable int id) {
		
		ShopEntity s1 = service.getShopByid(id) ;
		return s1;
	}
	
	@DeleteMapping("/DeleteShop/{id}")
	public String deleterecord(@PathVariable int id) {
		
		return service.deleterecord(id) ;
		
	}
	
	@PutMapping("UpdateShop/{id}")
	public String putMethodName(@PathVariable int id, @RequestBody ShopEntity s) {
		
		
		return service.updateshopRecordById(id, s);
	}
	
	

}
