package com.leonardojcv.springmongo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.leonardojcv.springmongo.dto.AuthorDTO;
import com.leonardojcv.springmongo.dto.CommentDTO;

import lombok.Data;

@Document
@Data
public class Post implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private Date date;
	private String title;
	private String body;
	private AuthorDTO author;
	
	private List<CommentDTO> comments = new ArrayList<>();

	public Post(String id, Date date, String title, String body, AuthorDTO author) {
		super();
		this.id = id;
		this.date = date;
		this.title = title;
		this.body = body;
		this.author = author;
	}

}
