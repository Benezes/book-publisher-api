package com.gabriel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabriel.dto.BookDTO;
import com.gabriel.service.AbstractService;

@RestController
@RequestMapping("/books")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BookController {

	@Autowired
	@Qualifier("bookService")
	private AbstractService<BookDTO> service;

	@GetMapping
	public ResponseEntity<Page<BookDTO>> findAllBooks(Pageable pageable) {
		return ResponseEntity.ok(service.findAll(pageable));
	}

	@GetMapping(value = "/{name}")
	public ResponseEntity<BookDTO> findBookByName(@PathVariable(value = "name") String name) {
		return ResponseEntity.ok(service.findByName(name));
	}

	@PostMapping
	public ResponseEntity<BookDTO> createBook(@RequestBody BookDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<BookDTO> updateBook(@PathVariable(value = "id") Long id, @RequestBody BookDTO dto) {
		return ResponseEntity.ok(service.update(id, dto));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable(value = "id") Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
