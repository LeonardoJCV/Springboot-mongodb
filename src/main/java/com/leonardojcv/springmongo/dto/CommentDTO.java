package com.leonardojcv.springmongo.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class CommentDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String text;
	private Date date;
	private AuthorDTO author;

	public CommentDTO(String text, Date date, AuthorDTO author) {
		super();
		this.text = text;
		this.date = date;
		this.author = author;
	}

}
