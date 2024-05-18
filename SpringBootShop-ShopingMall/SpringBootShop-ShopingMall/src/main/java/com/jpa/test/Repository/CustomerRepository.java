package com.jpa.test.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.test.Entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
