package com.rodsilca.springboot_social_posts_api.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.rodsilca.springboot_social_posts_api.domain.Post;

public interface PostRepository extends MongoRepository<Post, String>{
	List<Post> findByTitleContainingIgnoreCase(String text);
	@Query("{'title': { $regex: ?0, $options: 'i' } }")
	List<Post> findByTitle(String text);
}
