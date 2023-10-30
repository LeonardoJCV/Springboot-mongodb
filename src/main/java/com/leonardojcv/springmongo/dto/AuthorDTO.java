package com.leonardojcv.springmongo.dto;

import java.io.Serializable;

import com.leonardojcv.springmongo.domain.User;

import lombok.Data;

@Data
public class AuthorDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;

	public AuthorDTO(User obj) {
		id = obj.getId();
		name = obj.getName();
	}
	
}
