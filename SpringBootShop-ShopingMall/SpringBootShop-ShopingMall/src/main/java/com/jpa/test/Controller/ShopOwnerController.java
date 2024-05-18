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

import com.jpa.test.Entity.ShopOwner;
import com.jpa.test.Service.ShopOwnerService;

@RestController
@EntityScan("com.jpa.test.Entity")
@CrossOrigin(origins = "*", allowedHeaders="*")
public class ShopOwnerController {
	
	 @Autowired
	 ShopOwnerService service;
	 
	 // Save ShopOwner
	    @PostMapping("/SaveShopOwner")
	    public ShopOwner saveShopOwnerDetails(@RequestBody ShopOwner shopOwner) {
	        service.addShopOwner(shopOwner);
	        return shopOwner;
	    }

	    // Show all ShopOwners
	    @GetMapping("/ShopOwners")
	    public List<ShopOwner> getAllShopOwners() {
	        return service.getAllShopOwners();
	    }

	    // Show only one ShopOwner using id
	    @GetMapping("/ShopOwner/{id}")
	    public ShopOwner getShopOwner(@PathVariable int id) {
	        ShopOwner shopOwner = service.getShopOwnerById(id);
	        return shopOwner;
	    }

	    // Delete only one ShopOwner using id
	    @DeleteMapping("/ShopOwnerDelete/{id}")
	    public String deleteShopOwner(@PathVariable int id) {
	        return service.deleteShopOwnerById(id);
	    }

	    // Update one ShopOwner using id
	    @PutMapping("/ShopOwnerUpdate/{id}")
	    public String updateShopOwner(@PathVariable int id, @RequestBody ShopOwner shopOwner) {
	        return service.updateShopOwnerById(id, shopOwner);
	    }

}
