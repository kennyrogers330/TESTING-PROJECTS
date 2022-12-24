package com.sprinboot.prod.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprinboot.prod.app.model.Book;

public interface BooksRepository extends JpaRepository<Book, Integer>{
	Optional<Book> findBytitle(String title);
}
