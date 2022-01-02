package com.gabriel.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gabriel.dto.BookDTO;
import com.gabriel.entity.AuthorEntity;
import com.gabriel.entity.BookEntity;
import com.gabriel.repository.AuthorRepository;
import com.gabriel.repository.BookRepository;
import com.gabriel.service.exceptions.ItemNotFoundException;

@Service
@Qualifier("bookService")
public class BookService implements AbstractService<BookDTO> {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private AuthorRepository authorRepository;

	@Override
	public Page<BookDTO> findAll(Pageable pageable) {
		return bookRepository.findAll(pageable).map(BookDTO::new);
	}

	@Override
	public BookDTO findById(Long id) {
		BookEntity book = bookRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("Id not found"));
		return new BookDTO(book);
	}

	@Override
	public BookDTO findByName(String name) {
		BookEntity book = bookRepository.findByBookName(name)
				.orElseThrow(() -> new ItemNotFoundException("Id not found"));
		return new BookDTO(book);
	}

	@Override
	public BookDTO create(BookDTO dto) {

		Set<AuthorEntity> authors = new HashSet<>();

		for (AuthorEntity author : dto.getAuthors()) {
			authors.add(authorRepository.findByFullName(author.getFullName()).get());
		}

		dto.setAuthors(authors);
		BookEntity book = bookRepository.save(new BookEntity(dto));
		return new BookDTO(book);
	}

	@Override
	public BookDTO update(Long id, BookDTO dto) {
		BookDTO old = findById(id);
		BeanUtils.copyProperties(dto, old, "id");
		BookEntity book = bookRepository.save(new BookEntity(old));
		return new BookDTO(book);
	}

	@Override
	public void delete(Long id) {
		findById(id);
		bookRepository.deleteById(id);
	}

}
