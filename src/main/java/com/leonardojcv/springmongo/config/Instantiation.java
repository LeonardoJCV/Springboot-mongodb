package com.leonardojcv.springmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.leonardojcv.springmongo.domain.Post;
import com.leonardojcv.springmongo.domain.User;
import com.leonardojcv.springmongo.dto.AuthorDTO;
import com.leonardojcv.springmongo.dto.CommentDTO;
import com.leonardojcv.springmongo.repository.PostRepository;
import com.leonardojcv.springmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User leonardo = new User(null, "Leonardo Vieira", "leonardo@gmail.com");
		User jhenyfer = new User(null, "Jhenyfer Fernandes", "jhenyfer@gmail.com");
		User dua = new User(null, "Dua Lipa", "dua@gmail.com");
		
		userRepository.save(leonardo);
		userRepository.save(jhenyfer);
		userRepository.save(dua);
		
		Post post1 = new Post(null, sdf.parse("04/11/2023"), "Partiu show", "Vou para o show do Roger Waters", new AuthorDTO(leonardo));
		Post post2 = new Post(null, sdf.parse("30/10/2023"), "Bom dia", "Acordei feliz!", new AuthorDTO(leonardo));
		
		CommentDTO c1 = new CommentDTO("Bora!", sdf.parse("04/11/2023"), new AuthorDTO(dua));
		CommentDTO c2 = new CommentDTO("Uhul", sdf.parse("30/10/2023"), new AuthorDTO(jhenyfer));
		CommentDTO c3 = new CommentDTO("Que felicidade", sdf.parse("30/10/2023"), new AuthorDTO(jhenyfer));
		
		post1.getComments().addAll(Arrays.asList(c1));
		post2.getComments().addAll(Arrays.asList(c2, c3));
		
		postRepository.save(post1);
		postRepository.save(post2);
		
		leonardo.getPosts().addAll(Arrays.asList(post1, post2));
		
		userRepository.save(leonardo);
	}

}
