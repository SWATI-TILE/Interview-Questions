package com.jpa.test.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.jpa.test.Entity.ShopEntity;
import com.jpa.test.Repository.ShopRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ShopService {
	
	@Autowired
	ShopRepository repo;
	
	//save
	public ShopEntity addrecord(ShopEntity s) {
		
		return repo.save(s);
	}
	
	//Select all
	public List<ShopEntity> getAllshop() {
		return repo.findAll();
	}
	
	//Select ById
	public ShopEntity getShopByid(int sid) {
		ShopEntity s = null;
		 try {
			 Optional<ShopEntity> sitem =repo.findById(sid);
			 if(sitem.isPresent())
			 {
				 return sitem.get();
			 }
			
		 }
		 catch(NoSuchElementException excep)
		 {
			 System.out.println("No such record found");
		 }
		 
		 return s;
	}
	
	//Delete BYId
	public String deleterecord(int sid) {
		
		ShopEntity s = getShopByid(sid);
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
	public String updateshopRecordById(int sid, ShopEntity s)
	{
		ShopEntity sitem = getShopByid(sid);
		if(sitem == null)
		{
			return "shop record is not found for updation...";
		}
		else
		{
			repo.save(s);
			return "shop record is Updated";
		}
		
	}

}
