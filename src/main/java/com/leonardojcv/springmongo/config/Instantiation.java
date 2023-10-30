package com.leonardojcv.springmongo.config;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.leonardojcv.springmongo.domain.Post;
import com.leonardojcv.springmongo.domain.User;
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
		
		User leonardo = new User(null, "Leonardo Vieira", "leonardo@gmail.com");
		User jhenyfer = new User(null, "Jhenyfer Fernandes", "jhenyfer@gmail.com");
		User dua = new User(null, "Dua Lipa", "dua@gmail.com");
		
		Post post1 = new Post(null, sdf.parse("04/11/2023"), "Partiu show", "Vou para o show do Roger Waters", leonardo);
		Post post2 = new Post(null, sdf.parse("30/10/2023"), "Bom dia", "Acordei feliz!", leonardo);
		
		userRepository.save(leonardo);
		userRepository.save(jhenyfer);
		userRepository.save(dua);
		
		postRepository.save(post1);
		postRepository.save(post2);
	}

}
