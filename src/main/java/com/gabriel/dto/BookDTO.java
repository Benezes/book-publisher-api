package com.gabriel.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.gabriel.entity.AuthorEntity;
import com.gabriel.entity.BookEntity;
import com.gabriel.entity.LibraryEntity;
import com.gabriel.enums.GenderEnum;
import com.gabriel.enums.RateEnum;

public class BookDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String bookName;

	private Integer pages;

	private Double price;

	private Set<GenderEnum> genders = new HashSet<>();

	private RateEnum rate;

	private Set<AuthorEntity> authors = new HashSet<>();

	private Set<LibraryEntity> libraries = new HashSet<>();

	public BookDTO() {
		super();
	}

	public BookDTO(BookEntity entity) {
		this.id = entity.getId();
		this.bookName = entity.getBookName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Set<GenderEnum> getGenders() {
		return genders;
	}

	public void setGenders(Set<GenderEnum> genders) {
		this.genders = genders;
	}

	public RateEnum getRate() {
		return rate;
	}

	public void setRate(RateEnum rate) {
		this.rate = rate;
	}

	public Set<AuthorEntity> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<AuthorEntity> authors) {
		this.authors = authors;
	}

	public Set<LibraryEntity> getLibraries() {
		return libraries;
	}

	public void setLibraries(Set<LibraryEntity> libraries) {
		this.libraries = libraries;
	}

}
