package com.rodsilca.springboot_social_posts_api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodsilca.springboot_social_posts_api.domain.User;
import com.rodsilca.springboot_social_posts_api.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
}
