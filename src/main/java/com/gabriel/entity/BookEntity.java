package com.gabriel.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.gabriel.enums.GenderEnum;
import com.gabriel.enums.RateEnum;

@Entity
@Table(name = "tb_book")
public class BookEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String bookName;

	private Integer pages;

	private Double price;

	@Enumerated(EnumType.STRING)
	@ElementCollection
	private Set<GenderEnum> genders = new HashSet<>();

	@Enumerated(EnumType.STRING)
	private RateEnum rate;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "author_id"))
	private Set<AuthorEntity> authors = new HashSet<>();

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "books")
	private Set<LibraryEntity> libraries = new HashSet<>();

	public BookEntity() {
		super();
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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof BookEntity)) {
			return false;
		}
		BookEntity other = (BookEntity) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "BookEntity [id=" + id + ", bookName=" + bookName + ", pages=" + pages + ", price=" + price
				+ ", genders=" + genders + ", rate=" + rate + ", authors=" + authors + ", libraries=" + libraries + "]";
	}

}
