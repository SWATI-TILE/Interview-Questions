package com.jpa.test.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.test.Entity.ShopEntity;

public interface ShopRepository extends JpaRepository<ShopEntity, Integer>{

}
