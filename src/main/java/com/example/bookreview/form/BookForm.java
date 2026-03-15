package com.example.bookreview.form;

import java.sql.Date;

import lombok.Data;

@Data
public class BookForm {
	private String id;
	private String title;
	private String author;
	private Integer rating;
	private String comment;
	private Date readDate;
	
	public BookForm() {};
	
	public BookForm(String id, String title, String author, Integer rating, String comment, Date readDate) {
		
		this.id = id;
		this.title = title;
		this.author = author;
		this.rating = rating;
		this.comment = comment;
		this.readDate = readDate;
	}

}
