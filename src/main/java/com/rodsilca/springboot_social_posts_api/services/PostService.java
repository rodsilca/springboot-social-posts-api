package com.rodsilca.springboot_social_posts_api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodsilca.springboot_social_posts_api.domain.Post;
import com.rodsilca.springboot_social_posts_api.repository.PostRepository;
import com.rodsilca.springboot_social_posts_api.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repository;
		
	public Post findById(String id) {
		Optional<Post> user = repository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Post not found: "+id));
	}
	
	public List<Post> findByTitle(String text) {
		return repository.findByTitle(text);
	}
	
}
