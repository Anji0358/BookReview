package com.example.bookreview.entity;

import java.sql.Date;

import lombok.Data;

@Data
public class Book {
	
	private String id;
	private String title;
	private String author;
	private String publisher;
	private Date isbn;
	private String description;
	private Date created_at;
	private Date updated_at;
	
	public Book(String id, String title, String author, String publisher,Date isbn,
			String description,Date created_at,Date updated_at) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.publisher=publisher;
		this.isbn=isbn;
		this.description=description;
		this.created_at=created_at;
		this.updated_at=updated_at;
	}
}
