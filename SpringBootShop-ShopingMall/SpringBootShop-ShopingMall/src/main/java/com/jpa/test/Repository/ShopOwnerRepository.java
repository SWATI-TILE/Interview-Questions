package com.jpa.test.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.test.Entity.ShopOwner;


public interface ShopOwnerRepository extends JpaRepository<ShopOwner, Integer> {

}
