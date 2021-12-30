package com.gabriel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gabriel.dto.BookDTO;
import com.gabriel.repository.BookRepository;

@Service
@Qualifier("bookService")
public class BookService implements AbstractService<BookDTO> {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public Page<BookDTO> findAll(Pageable pageable) {
		return bookRepository.findAll(pageable).map(BookDTO::new);
	}

}
