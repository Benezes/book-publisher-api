package com.gabriel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabriel.dto.AuthorDTO;
import com.gabriel.service.AbstractService;

@RestController
@RequestMapping("/authors")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthorController {

	@Autowired
	@Qualifier("authorService")
	private AbstractService<AuthorDTO> service;

	@GetMapping
	public ResponseEntity<Page<AuthorDTO>> findAllAuthors(Pageable pageable) {
		return ResponseEntity.ok(service.findAll(pageable));
	}
}
