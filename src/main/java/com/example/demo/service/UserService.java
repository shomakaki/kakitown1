package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User insert(User user) {
		return userRepository.insert(user);
	}
	public User login(String email) {
		User user = new User();
		System.out.println("ser:"+user);
		return userRepository.load(email);

	}
}
