package com.rodsilca.springboot_social_posts_api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rodsilca.springboot_social_posts_api.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
	
}
