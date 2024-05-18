package com.jpa.test.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.test.Entity.User;
import com.jpa.test.Repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService {

	 @Autowired
	 UserRepository userRepository;
	 
	 public User addUser(User user) {
	        return userRepository.save(user);
	    }

	    public List<User> getAllUsers() {
	        return userRepository.findAll();
	    }

	    public User getUserById(int userId) {
	        User user = null;
	        try {
	            Optional<User> optionalUser = userRepository.findById(userId);
	            if (optionalUser.isPresent()) {
	                return optionalUser.get();
	            }
	        } catch (NoSuchElementException exception) {
	            System.out.println("No such record found");
	        }

	        return user;
	    }

	    public String deleteUserById(int userId) {
	        User user = getUserById(userId);
	        if (user == null) {
	            return "Record is not found";
	        } else {
	            userRepository.deleteById(userId);
	            return "Record is deleted";
	        }
	    }

	    public String updateUserById(int userId, User user) {
	        User existingUser = getUserById(userId);
	        if (existingUser == null) {
	            return "User record is not found for updation...";
	        } else {
	            user.setUserId(userId);
	            userRepository.save(user);
	            return "User record is updated";
	        }
	    }
}
