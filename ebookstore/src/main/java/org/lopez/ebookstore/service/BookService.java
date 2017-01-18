package org.lopez.ebookstore.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.lopez.ebookstore.model.Book;

public interface BookService {

	public List<Book> findAllBooks();
	
	public Book findBookById(int id);
	
	public void addBook(Book book);
	
	public void deleteBook(int id);
	
	public void updateBook(Book book);

	public void addBook(Book book, HttpServletRequest request);
	
	public void deleteBook(int id, HttpServletRequest request);

	void updateBook(Book book, HttpServletRequest request);
}
