package com.gabriel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gabriel.entity.LibraryEntity;

@Repository
public interface LibraryRepository extends JpaRepository<LibraryEntity, Long> {

}
