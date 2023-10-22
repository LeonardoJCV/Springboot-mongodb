package com.leonardojcv.springmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leonardojcv.springmongo.domain.User;
import com.leonardojcv.springmongo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	public UserRepository repository;
	
	public List<User>findAll(){
		return repository.findAll();
	}
	
}
