package com.gabriel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gabriel.entity.BookEntity;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {

}
