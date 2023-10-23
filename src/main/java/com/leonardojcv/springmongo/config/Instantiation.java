package com.leonardojcv.springmongo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.leonardojcv.springmongo.domain.User;
import com.leonardojcv.springmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		userRepository.deleteAll();
		
		User leonardo = new User(null, "Leonardo Vieira", "leonardo@gmail.com");
		User jhenyfer = new User(null, "Jhenyfer Fernandes", "jhenyfer@gmail.com");
		User dua = new User(null, "Dua Lipa", "dua@gmail.com");
		
		userRepository.save(leonardo);
		userRepository.save(jhenyfer);
		userRepository.save(dua);
	}

}
