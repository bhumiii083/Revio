package com.revio.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revio.dto.AuthResponse;
import com.revio.dto.LoginRequest;
import com.revio.dto.MessageResponse;
import com.revio.dto.RegisterRequest;
import com.revio.service.UserService;


@CrossOrigin
@RestController
@RequestMapping("/auth")
public class AuthController {
	
  
	private final UserService userService;

	public AuthController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@PostMapping("/register")
	public ResponseEntity<MessageResponse> register(@RequestBody RegisterRequest request){
		return ResponseEntity.ok(userService.register(request));
	}
	
	@PostMapping("/login")
	public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request){
		return ResponseEntity.ok(userService.login(request));
	}
	
}
