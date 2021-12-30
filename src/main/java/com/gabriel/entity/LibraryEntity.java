package com.gabriel.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_library")
public class LibraryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String libraryName;

	private Integer companyRegistration;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "book_library", joinColumns = @JoinColumn(name = "library_id"), inverseJoinColumns = @JoinColumn(name = "book_id"))
	private Set<BookEntity> books = new HashSet<>();

	public LibraryEntity() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLibraryName() {
		return libraryName;
	}

	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}

	public Integer getCompanyRegistration() {
		return companyRegistration;
	}

	public void setCompanyRegistration(Integer companyRegistration) {
		this.companyRegistration = companyRegistration;
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
		if (!(obj instanceof LibraryEntity)) {
			return false;
		}
		LibraryEntity other = (LibraryEntity) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "LibraryEntity [id=" + id + ", libraryName=" + libraryName + ", companyRegistration="
				+ companyRegistration + ", books=" + books + "]";
	}

}
