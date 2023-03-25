package com.example.demo.service2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.demo.entity2.User;
import com.example.demo.entity2.UserPrincipal;
import com.example.demo.repository2.UserRepo;

@Service

public class UserService2 {

	@Autowired
	private UserRepo userRepo;
	
	public User getUserById(Long id) {
		return  userRepo.findById(id).get();
	}
	
	
}
