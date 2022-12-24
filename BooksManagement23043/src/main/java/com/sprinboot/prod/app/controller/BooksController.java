package com.sprinboot.prod.app.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprinboot.prod.app.model.Book;
import com.sprinboot.prod.app.service.impl.BookServiceImpl;

@RestController
@RequestMapping("/Books/api")
public class BooksController {
	BookServiceImpl bookServiceImpl;
	
	public BooksController(BookServiceImpl bookServiceImpl) {
		super();
		this.bookServiceImpl = bookServiceImpl;
	}


	//create Book REST API
	@PostMapping()
	public ResponseEntity<Book> saveBook(@RequestBody Book book){
		return new ResponseEntity<Book>(bookServiceImpl.createBook(book), HttpStatus.CREATED);
	}
	
	//Get All Books REST API
	@GetMapping()
	public List<Book> getAllBooks(){
		return bookServiceImpl.getAllBooks();
	}
	
	//Get Book BY Title REST API
	@GetMapping("{title}")
	public ResponseEntity<Book> findBookBYTitle(@PathVariable("title") String btitle) {
		return new ResponseEntity<Book>(bookServiceImpl.findBook(btitle),HttpStatus.OK);
	}
	
	//Update Book REST API
	@PutMapping("{id}")
	public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable("id") int Id) {
		return new ResponseEntity<Book>(bookServiceImpl.UpdateBook(book, Id), HttpStatus.OK);
	}
	
	//Delete Book REST API
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteBook(@PathVariable("id") int Id){
		return new ResponseEntity<String>("Book delete", HttpStatus.OK);
	}
}
