package com.jpa.test.Controller;

import java.util.List;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
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

import com.jpa.test.Entity.ItemEntity;
import com.jpa.test.Service.ItemService;





@RestController
@EntityScan("com.test.Entity")
@CrossOrigin(origins = "*", allowedHeaders="*")
public class ItemController {
	
	@Autowired
    ItemService service;

    // Save item
    @PostMapping("/SaveItem")
    public int saveItemDetails(@RequestBody ItemEntity item) {
        service.addItem(item);
        return 0;
    }

    // Show all items
    @GetMapping("/Items")
    public List<ItemEntity> getAllItems() {
        return service.getAllItems();
    }

    // Show only one item using id
    @GetMapping("/Item/{id}")
    public ItemEntity getItem(@PathVariable int id) {
    	ItemEntity item = service.getItemById(id);
        return item;
    }

    // Delete only one item using id
    @DeleteMapping("/ItemDelete/{id}")
    public String deleteItem(@PathVariable int id) {
        return service.deleteItemById(id);
    }

    // Update one item using id
    @PutMapping("/ItemUpdate/{id}")
    public String updateItem(@PathVariable int id, @RequestBody ItemEntity item) {
        return service.updateItemById(id, item);
    }
	

}
