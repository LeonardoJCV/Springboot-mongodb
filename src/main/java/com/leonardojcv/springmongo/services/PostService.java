package com.leonardojcv.springmongo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leonardojcv.springmongo.domain.Post;
import com.leonardojcv.springmongo.repository.PostRepository;
import com.leonardojcv.springmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	public PostRepository repository;

	public Post findById(String id) {
		Optional<Post> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
	}

}
