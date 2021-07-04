package com.userviewer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.userviewer.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Cacheable("user-exists-cache")
	public Boolean isUserExists(Long userExist) {
		return userRepository.existsById(userExist);
	}
}
