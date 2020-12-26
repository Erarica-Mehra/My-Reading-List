package com.goodreads.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "my_shelf")
public class MyShelf implements Serializable {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "bookid")
	private int bookId;

	@Column(name = "title")
	private String title;

	@Column(name = "author")
	private String author;

	@Column(name = "status")
	private String status;

	@Column(name = "image_url")
	private String imageUrl;

	@Column(name = "rating")
	private double rating;

	public MyShelf(int id, int bookId, String title, String author, String status, double rating) {
		super();
		this.id = id;
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.status = status;
		this.rating = rating;
	}

	public MyShelf(int bookId, String title, String author, String status, String imageUrl, double rating) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.status = status;
		this.imageUrl = imageUrl;
		this.rating = rating;
	}

	public MyShelf() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}
	
}
