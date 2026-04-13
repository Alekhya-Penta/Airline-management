package com.spring.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.User;
import com.spring.repo.UserRepository;


@RestController
@RequestMapping("/users")
public class UserController {
	
	 private final UserRepository repo;

	    public UserController(UserRepository repo) {
	        this.repo = repo;
	    }

	    @PostMapping
	    public User createUser(@RequestBody User user) {
	        return repo.save(user);
	    }

	    @GetMapping
	    public List<User> getAllUsers() {
	        return repo.findAll();
	    }
	    @GetMapping("/{id}")
	    public User getUserById(@PathVariable Long id) {
	        Optional<User> optionalUser = repo.findById(id);
	        return optionalUser.orElseThrow(() -> new RuntimeException("User not found with id: " + id));
	    }

	    
	    @PostMapping("/forgot-password")
	    public String forgotPassword(@RequestBody Map<String, String> body) {
	        String email = body.get("email");
	        String newPassword = body.get("newPassword");
	        
	        Optional<User> optionalUser = repo.findByEmail(email);
	        if (optionalUser.isPresent()) {
	            User user = optionalUser.get();
	            user.setPassword(newPassword); // In production, hash the password!
	            repo.save(user);
	            return "Password updated successfully.";
	        } else {
	            return "User not found.";
	        }
	    }
	   

}
