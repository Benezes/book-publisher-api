package com.gabriel.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tb_author")
public class AuthorEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String fullName;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate birthday;

	private String nationality;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "authors")
	private Set<BookEntity> books = new HashSet<>();

	public AuthorEntity() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public Set<BookEntity> getBooks() {
		return books;
	}

	public void setBooks(Set<BookEntity> books) {
		this.books = books;
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
		if (!(obj instanceof AuthorEntity)) {
			return false;
		}
		AuthorEntity other = (AuthorEntity) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "AuthorEntity [id=" + id + ", fullName=" + fullName + ", birthday=" + birthday + ", nationality="
				+ nationality + ", books=" + books + "]";
	}

}
