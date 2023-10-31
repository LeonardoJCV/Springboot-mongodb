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
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userReposiroty;

	@Autowired
	private PostRepository postReposiroty;

	@Override
	public void run(String... arg0) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userReposiroty.deleteAll();
		postReposiroty.deleteAll();
		
		User leonardo = new User(null, "Leonardo Vieira", "leonardo@gmail.com");
		User jhenyfer = new User(null, "Jhenyfer Fernandes", "jhenyfer@gmail.com");
		User dua = new User(null, "Dua Lipa", "dua@gmail.com");
		
		userReposiroty.saveAll(Arrays.asList(leonardo, jhenyfer, dua));

		Post post1 = new Post(null, sdf.parse("04/11/2023"), "Partiu Roger Waters!", "Vou pro show do Roger. Abraços!", new AuthorDTO(leonardo));
		Post post2 = new Post(null, sdf.parse("30/10/2023"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(leonardo));

		CommentDTO c1 = new CommentDTO("Bom show!", sdf.parse("21/03/2018"), new AuthorDTO(jhenyfer));
		CommentDTO c2 = new CommentDTO("Aproveite", sdf.parse("22/03/2018"), new AuthorDTO(dua));
		CommentDTO c3 = new CommentDTO("Boa", sdf.parse("22/03/2018"), new AuthorDTO(dua));
		
		post1.getComments().addAll(Arrays.asList(c1, c2));
		post2.getComments().addAll(Arrays.asList(c3));
		
		postReposiroty.saveAll(Arrays.asList(post1, post2));
		
		leonardo.getPosts().addAll(Arrays.asList(post1, post2));
		userReposiroty.save(leonardo);
	}

}
