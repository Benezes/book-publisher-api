package com.gabriel.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AbstractService<T> {

	public abstract Page<T> findAll(Pageable pageable);
	
}
