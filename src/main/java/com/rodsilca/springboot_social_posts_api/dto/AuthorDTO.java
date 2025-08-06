package com.rodsilca.springboot_social_posts_api.dto;

import java.io.Serializable;

import com.rodsilca.springboot_social_posts_api.domain.User;

public class AuthorDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	
	public AuthorDTO() {
		
	}
	
	public AuthorDTO(User obj) {
		id = obj.getId();
		name = obj.getName();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
