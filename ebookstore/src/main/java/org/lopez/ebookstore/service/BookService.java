package org.lopez.ebookstore.service;

import java.util.List;

import org.lopez.ebookstore.model.Book;

public interface BookService {

	public List<Book> findAllBooks();
	
	public Book findBookById(int id);
	
	public void addBook(Book book);
	
	public void deleteBook(int id);
}
