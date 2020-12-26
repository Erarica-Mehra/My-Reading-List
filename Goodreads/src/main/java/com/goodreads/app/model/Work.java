
package com.goodreads.app.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "work")
@XmlAccessorType(XmlAccessType.FIELD)
public class Work {

	@XmlElement(name = "id")
	private int id;

	@XmlElement(name = "books_count")
	private int booksCount;

	@XmlElement(name = "ratings_count")
	private int ratingsCount;

	@XmlElement(name = "text_reviews_count")
	private int textReviewCount;

	@XmlElement(name = "original_publication_year")
	private int originalPublicationYear;

	@XmlElement(name = "average_rating")
	private double averageRating;

	@XmlElement(name = "best_book")
	private BestBook bestBook;

	public int getTextReviewCount() {
		return textReviewCount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBooksCount() {
		return booksCount;
	}

	public void setBooksCount(int booksCount) {
		this.booksCount = booksCount;
	}

	public int getRatingsCount() {
		return ratingsCount;
	}

	public void setRatingsCount(int ratingsCount) {
		this.ratingsCount = ratingsCount;
	}

	public int getOriginalPublicationYear() {
		return originalPublicationYear;
	}

	public void setOriginalPublicationYear(int originalPublicationYear) {
		this.originalPublicationYear = originalPublicationYear;
	}

	public BestBook getBestBook() {
		return bestBook;
	}

	public void setBestBook(BestBook bestBook) {
		this.bestBook = bestBook;
	}

	public void setTextReviewCount(int textReviewCount) {
		this.textReviewCount = textReviewCount;
	}

	public double getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(double averageRating) {
		this.averageRating = averageRating;
	}


}
