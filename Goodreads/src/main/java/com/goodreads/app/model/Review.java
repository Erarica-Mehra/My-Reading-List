package com.goodreads.app.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "review")
@XmlAccessorType(XmlAccessType.FIELD)
public class Review {
	
	private int id;
    private Book book;
    private int rating;
    private String body;
    private String link;
}
