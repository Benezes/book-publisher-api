package com.gabriel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gabriel.dto.AuthorDTO;
import com.gabriel.repository.AuthorRepository;

@Service
@Qualifier("authorService")
public class AuthorService implements AbstractService<AuthorDTO> {

	@Autowired
	private AuthorRepository authorRepository;

	@Override
	public Page<AuthorDTO> findAll(Pageable pageable) {
		return authorRepository.findAll(pageable).map(AuthorDTO::new);
	}

}
