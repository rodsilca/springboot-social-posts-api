package com.rodsilca.springboot_social_posts_api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rodsilca.springboot_social_posts_api.domain.Post;

public interface PostRepository extends MongoRepository<Post, String>{

}
