package com.revio.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.revio.dto.AuthResponse;
import com.revio.dto.LoginRequest;
import com.revio.dto.MessageResponse;
import com.revio.dto.RegisterRequest;
import com.revio.dto.UserResponse;
import com.revio.entity.User;
import com.revio.exception.EmailAlreadyExistsException;
import com.revio.exception.InvalidCredentialsException;
import com.revio.exception.UserNotFoundException;
import com.revio.mapper.UserMapper;
import com.revio.repo.UserRepository;
import com.revio.security.JwtService;

@Service
public class UserServiceImpl implements UserService {
	
	private final UserRepository repo;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;
	
	

	public UserServiceImpl(UserRepository repo, PasswordEncoder passwordEncoder, JwtService jwtService) {
		super();
		this.repo = repo;
		this.passwordEncoder = passwordEncoder;
		this.jwtService = jwtService;
	}

	@Override
	public MessageResponse register(RegisterRequest request) {

	    if(repo.existsByEmail(request.getEmail())) {
	        throw new EmailAlreadyExistsException("Email already exists!");
	    }

	    User user = new User();

	    user.setName(request.getName());
	    user.setEmail(request.getEmail());
	    user.setPassword(passwordEncoder.encode(request.getPassword()));
	    user.setRole(request.getRole());

	    repo.save(user);

	    return new MessageResponse(
	            "User registered successfully!"
	    );
	}

	@Override
	public AuthResponse login(LoginRequest request) {

		User user = repo.findByEmail(request.getEmail())
				.orElseThrow(() -> new UserNotFoundException("User not found!"));
		
		if(!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
			throw new InvalidCredentialsException("Invalid Password!");
		}
		String token = jwtService.generateToken(user);
		
		return new AuthResponse(token, "Login Successful!");
	}

	@Override
	public UserResponse getUserById(Long id) {
		User user = repo.findById(id)
				.orElseThrow(() -> new UserNotFoundException("User not found!"));
		return UserMapper.toUserResponse(user);
	}

	@Override
	public List<UserResponse> getAllUsers() {
		List<User> users= repo.findAll();
		
		List<UserResponse> responses = new ArrayList<>();
		
		for(User user:users) {
			responses.add(
					UserMapper.toUserResponse(user));
		}
		return responses;
	}
	
	
	

}
