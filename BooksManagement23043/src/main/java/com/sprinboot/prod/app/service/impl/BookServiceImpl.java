package com.sprinboot.prod.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sprinboot.prod.app.model.Book;
import com.sprinboot.prod.app.repository.BooksRepository;
import com.sprinboot.prod.app.service.BookService;
@Service
public class BookServiceImpl implements BookService{
	BooksRepository booksRepository;
	
	public BookServiceImpl(BooksRepository booksRepository) {
		super();
		this.booksRepository = booksRepository;
	}

	@Override
	public Book createBook(Book book) {
		return booksRepository.save(book);
	}

	@Override
	public List<Book> getAllBooks() {
		return booksRepository.findAll();
	}

	@Override
	public Book findBook(String title) {
		Optional<Book> book = booksRepository.findBytitle(title);
		if(book.isPresent()) {
			return book.get();
		}else {
			throw new RuntimeException("not found");
		}
		
	}

	@Override
	public Book UpdateBook(Book bk, int id) {
		Optional<Book> book = booksRepository.findById(id);
		if(!book.isPresent()) {
		throw new RuntimeException("not found");
	}
		Book book1 = book.get();
		book1.setTitle(bk.getTitle());
		book1.setAuthorFirstName(bk.getAuthorFirstName());
		book1.setAuthorLastName(bk.getAuthorLastName());
		book1.setAuthorEmail(bk.getAuthorEmail());
		booksRepository.save(book1);
		return booksRepository.save(book1);
	}

	@Override
	public void deleteBook(int id) {
		Optional<Book> book = booksRepository.findById(id);
		if(!book.isPresent()) {
		throw new RuntimeException("not found");
	}
		booksRepository.deleteById(id);
	}
}
