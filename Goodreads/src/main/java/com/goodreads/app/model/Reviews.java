package com.goodreads.app.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "reviews")
@XmlAccessorType(XmlAccessType.FIELD)
public class Reviews {
	
	private List<Review> review;

}
