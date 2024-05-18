package com.jpa.test.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.test.Entity.OrderDetails;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer>{

}
