package com.rodsilca.springboot_social_posts_api.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.rodsilca.springboot_social_posts_api.domain.Post;
import com.rodsilca.springboot_social_posts_api.domain.User;
import com.rodsilca.springboot_social_posts_api.dto.AuthorDTO;
import com.rodsilca.springboot_social_posts_api.repository.PostRepository;
import com.rodsilca.springboot_social_posts_api.repository.UserRepository;


@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria,alex,bob));
		
		Post post1 = new Post(null, sdf.parse("21/03/2025"),"Viagem", "Vou viajar", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("22/03/2025"),"htklsfklsdf", "Vou kfjsdkfjsd",new AuthorDTO(maria) );
		
		
		
		postRepository.saveAll(Arrays.asList(post1,post2));
		
	}
	
	
}
