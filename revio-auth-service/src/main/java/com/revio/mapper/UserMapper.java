package com.revio.mapper;

import com.revio.dto.UserResponse;
import com.revio.entity.User;

public class UserMapper {

	public static UserResponse toUserResponse(User user) {
		UserResponse res = new UserResponse();
		
		res.setId(user.getId());
		res.setName(user.getName());
		res.setEmail(user.getEmail());
		res.setRole(user.getRole());
		
		return res;
	}
}
