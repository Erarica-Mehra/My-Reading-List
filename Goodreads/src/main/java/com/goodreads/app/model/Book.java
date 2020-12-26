package com.goodreads.app.model;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement(name = "book")
@XmlAccessorType(XmlAccessType.FIELD)
public class Book {
	@XmlElement(name = "id")
	private int id;

	@XmlElement(name = "title")
	String title;

	private List<Author> author;

	@XmlElement(name = "image_url")
	private String imageUrl;

	public String getTitle() {
		return title;
	}

	public void setTitle(String ttitle) {
		title = ttitle;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

}
