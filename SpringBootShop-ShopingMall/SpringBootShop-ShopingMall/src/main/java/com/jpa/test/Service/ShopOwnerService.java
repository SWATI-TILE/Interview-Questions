package com.jpa.test.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.test.Entity.ShopOwner;
import com.jpa.test.Repository.ShopOwnerRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ShopOwnerService {
	
	 @Autowired
	 ShopOwnerRepository repo;
	 
	 public ShopOwner addShopOwner(ShopOwner shopOwner) {
	        return repo.save(shopOwner);
	    }

	    public List<ShopOwner> getAllShopOwners() {
	        return repo.findAll();
	    }

	    public ShopOwner getShopOwnerById(int shopOwnerId) {
	        ShopOwner shopOwner = null;
	        try {
	            Optional<ShopOwner> optionalShopOwner = repo.findById(shopOwnerId);
	            if (optionalShopOwner.isPresent()) {
	                return optionalShopOwner.get();
	            }
	        } catch (NoSuchElementException exception) {
	            System.out.println("No such record found");
	        }

	        return shopOwner;
	    }

	    public String deleteShopOwnerById(int shopOwnerId) {
	        ShopOwner shopOwner = getShopOwnerById(shopOwnerId);
	        if (shopOwner == null) {
	            return "Record is not found";
	        } else {
	            repo.deleteById(shopOwnerId);
	            return "Record is deleted";
	        }
	    }

	    public String updateShopOwnerById(int shopOwnerId, ShopOwner shopOwner) {
	        ShopOwner existingShopOwner = getShopOwnerById(shopOwnerId);
	        if (existingShopOwner == null) {
	            return "ShopOwner record is not found for updation...";
	        } else {
	            shopOwner.setUserId(shopOwnerId);
	            repo.save(shopOwner);
	            return "ShopOwner record is updated";
	        }
	    }


}
