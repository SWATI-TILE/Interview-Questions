package com.jpa.test.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.test.Entity.User;
import com.jpa.test.Service.UserService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders="*")
public class UserController {

	@Autowired
    UserService userService;
	
	@PostMapping("/saveUser")
    public User saveUserDetails(@RequestBody User user) {
        userService.addUser(user);
        return user;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable int id) {
        User user = userService.getUserById(id);
        return user;
    }

    @DeleteMapping("/userDelete/{id}")
    public String deleteUser(@PathVariable int id) {
        return userService.deleteUserById(id);
    }

    @PutMapping("/userUpdate/{id}")
    public String updateUser(@PathVariable int id, @RequestBody User user) {
        return userService.updateUserById(id, user);
    }
}
