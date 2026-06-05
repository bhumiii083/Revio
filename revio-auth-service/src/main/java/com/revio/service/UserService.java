package com.revio.service;

import java.util.List;

import com.revio.dto.AuthResponse;
import com.revio.dto.LoginRequest;
import com.revio.dto.MessageResponse;
import com.revio.dto.RegisterRequest;
import com.revio.dto.UserResponse;

public interface UserService {

	MessageResponse register(RegisterRequest req);
	
	AuthResponse login(LoginRequest request);
	
	UserResponse getUserById(Long id);
	
	List<UserResponse> getAllUsers();
		
	
}
