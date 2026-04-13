package com.spring.serviceimp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.User;
import com.spring.repo.UserRepository;
import com.spring.service.UserService;

@Service
public class UserServiceImp implements UserService{
	
	@Autowired
	 private final UserRepository userRepository;

	    public UserServiceImp(UserRepository userRepository) {
	        this.userRepository = userRepository;
	    }

	    @Override
	    public User createUser(User user) {
	        return userRepository.save(user);
	    }

	    @Override
	    public List<User> getAllUsers() {
	        return userRepository.findAll();
	    }
	    @Override
	    public String updatePasswordByEmail(String email, String newPassword) {
	        Optional<User> userOpt = userRepository.findByEmail(email);
	        if (userOpt.isPresent()) {
	            User user = userOpt.get();
	            user.setPassword(newPassword);
	            userRepository.save(user);
	            return "Password updated successfully.";
	        } else {
	            return "User not found.";
	        }
	    }
	}
	


