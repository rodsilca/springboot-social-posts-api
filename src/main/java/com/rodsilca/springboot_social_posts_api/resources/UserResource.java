package com.rodsilca.springboot_social_posts_api.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rodsilca.springboot_social_posts_api.domain.Post;
import com.rodsilca.springboot_social_posts_api.domain.User;
import com.rodsilca.springboot_social_posts_api.dto.UserDTO;
import com.rodsilca.springboot_social_posts_api.services.UserService;

@RestController
@RequestMapping(value= "/users")
public class UserResource {
	@Autowired
	private UserService service;

	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll(){
		List<User> usuarios = service.findAll();
		List<UserDTO> listDto = usuarios.stream().map(x -> new UserDTO(x)).toList();
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id){
		User user = service.findById(id);
		UserDTO userDTO = new UserDTO(user);
		return ResponseEntity.ok().body(userDTO);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody UserDTO obj){
		User user = service.fromDTO(obj);
		user = service.insert(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody UserDTO obj ,@PathVariable String id){
		User user = service.fromDTO(obj);	
		user.setId(id);
		user =  service.update(user);
		return ResponseEntity.noContent().build();
	}
	

	@GetMapping(value = "/{id}/posts")
	public ResponseEntity<List<Post>> findPosts(@PathVariable String id){
		User user = service.findById(id);
		return ResponseEntity.ok().body(user.getPosts());
	}
}
