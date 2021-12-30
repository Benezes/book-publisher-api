package com.gabriel.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gabriel.entity.AuthorEntity;

public class AuthorDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String fullName;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate birthday;

	private String nationality;

	public AuthorDTO() {
		super();
	}

	public AuthorDTO(AuthorEntity entity) {
		this.id = entity.getId();
		this.fullName = entity.getFullName();
		this.birthday = entity.getBirthday();
		this.nationality = entity.getNationality();
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

}
