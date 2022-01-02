package com.gabriel.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gabriel.dto.AuthorDTO;
import com.gabriel.entity.AuthorEntity;
import com.gabriel.repository.AuthorRepository;
import com.gabriel.service.exceptions.ItemNotFoundException;

@Service
@Qualifier("authorService")
public class AuthorService implements AbstractService<AuthorDTO> {

	@Autowired
	private AuthorRepository authorRepository;

	@Override
	public Page<AuthorDTO> findAll(Pageable pageable) {
		return authorRepository.findAll(pageable).map(AuthorDTO::new);
	}

	@Override
	public AuthorDTO findById(Long id) {
		AuthorEntity author = authorRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("Id not found"));
		return new AuthorDTO(author);
	}

	@Override
	public AuthorDTO findByName(String name) {
		AuthorEntity author = authorRepository.findByFullName(name)
				.orElseThrow(() -> new ItemNotFoundException("Name not found"));
		return new AuthorDTO(author);
	}

	@Override
	public AuthorDTO create(AuthorDTO dto) {
		AuthorEntity author = authorRepository.save(new AuthorEntity(dto));
		return new AuthorDTO(author);
	}

	@Override
	public AuthorDTO update(Long id, AuthorDTO dto) {
		AuthorDTO old = findById(id);
		BeanUtils.copyProperties(dto, old, "id");
		AuthorEntity author = authorRepository.save(new AuthorEntity(old));
		return new AuthorDTO(author);
	}

	@Override
	public void delete(Long id) {
		findById(id);
		authorRepository.deleteById(id);
	}

}
