package com.gabriel.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AbstractService<T> {

	public abstract Page<T> findAll(Pageable pageable);

	public abstract T findById(Long id);

	public abstract T findByName(String name);

	public abstract T create(T dto);

	public abstract T update(Long id, T dto);

	public abstract void delete(Long id);

}
