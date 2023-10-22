package com.leonardojcv.springmongo.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="user")
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String name;
	private String email;
	
	public User(String id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}
}
