package com.rodsilca.springboot_social_posts_api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodsilca.springboot_social_posts_api.domain.User;
import com.rodsilca.springboot_social_posts_api.dto.UserDTO;
import com.rodsilca.springboot_social_posts_api.repository.UserRepository;
import com.rodsilca.springboot_social_posts_api.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User fingById(String id) {
		Optional<User> user = repository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("User not found: "+id));
	}
	
	public User insert(User obj) {
		return repository.insert(obj);
	}
	
	public User fromDTO(UserDTO obj) {
		return new User(obj.getId(), obj.getName(), obj.getEmail());
	}
	
	public void delete(String id) {
		fingById(id);
		repository.deleteById(id);
	}
}
