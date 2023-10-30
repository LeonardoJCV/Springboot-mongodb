package com.leonardojcv.springmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.leonardojcv.springmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

}
