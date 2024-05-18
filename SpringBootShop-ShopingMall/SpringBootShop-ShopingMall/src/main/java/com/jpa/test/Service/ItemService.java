package com.jpa.test.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.test.Entity.ItemEntity;
import com.jpa.test.Repository.ItemRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ItemService {
	
	  @Autowired
	    ItemRepository repo;

	    public ItemEntity addItem(ItemEntity item) {
	        return repo.save(item);
	    }

	    public List<ItemEntity> getAllItems() {
	        return repo.findAll();
	    }

	    public ItemEntity getItemById(int itemId) {
	    	ItemEntity item = null;
	        try {
	       java.util.Optional<ItemEntity> optionalItem = repo.findById(itemId);
	            if (optionalItem.isPresent()) {
	                return optionalItem.get();
	            }
	        } catch (NoSuchElementException exception) {
	            System.out.println("No such record found");
	        }

	        return item;
	    }

	    public String deleteItemById(int itemId) {
	    	ItemEntity item = getItemById(itemId);
	        if (item == null) {
	            return "Record is not found";
	        } else {
	            repo.deleteById(itemId);
	            return "Record is deleted";
	        }
	    }

	    public String updateItemById(int itemId, ItemEntity item) {
	    	ItemEntity existingItem = getItemById(itemId);
	        if (existingItem == null) {
	            return "Item record is not found for updation...";
	        } else {
	            item.setItemId(itemId);
	            repo.save(item);
	            return "Item record is updated";
	        }
	    }


}
