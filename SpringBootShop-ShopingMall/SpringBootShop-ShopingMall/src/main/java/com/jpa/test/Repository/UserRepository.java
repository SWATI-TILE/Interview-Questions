package com.jpa.test.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.test.Entity.User;
public interface UserRepository extends JpaRepository<User, Integer> {

}




