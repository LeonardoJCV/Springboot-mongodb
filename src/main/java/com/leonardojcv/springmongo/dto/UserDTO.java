package com.leonardojcv.springmongo.dto;

import java.io.Serializable;

import com.leonardojcv.springmongo.domain.User;

import lombok.Data;

@Data
public class UserDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String email;
	
	public UserDTO(User obj) {
		id = obj.getId();
		name = obj.getName();
		email = obj.getEmail();
	}
	
}
