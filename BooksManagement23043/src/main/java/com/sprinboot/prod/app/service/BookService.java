package com.sprinboot.prod.app.service;

import java.util.List;

import com.sprinboot.prod.app.model.Book;

public interface BookService {
	Book createBook(Book book);
	List<Book> getAllBooks();
	Book findBook(String title);
	Book UpdateBook(Book bk, int id);
	void deleteBook(int id);
}
