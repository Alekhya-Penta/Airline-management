package com.spring.service;

import java.util.List;

import com.spring.entity.User;


public interface UserService {
	
	User createUser(User user);
    List<User> getAllUsers();
    String updatePasswordByEmail(String email, String newPassword);

}
