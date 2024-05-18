package com.jpa.test.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.test.Entity.ItemEntity;

public interface ItemRepository extends JpaRepository<ItemEntity, Integer>{
	
	

}
