package com.rodsilca.springboot_social_posts_api.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rodsilca.springboot_social_posts_api.domain.User;

@RestController
@RequestMapping(value= "/users")
public class UserResource {

	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		User maria = new User("1","maria","sdjfksdjfksdjfksdj");
		User alex = new User("2","alex","sdjfksdjfksdjfksdj");
		
		List<User> usuarios = new ArrayList<>();
		usuarios.addAll(Arrays.asList(maria,alex));
		
		return ResponseEntity.ok().body(usuarios);
	}
}
