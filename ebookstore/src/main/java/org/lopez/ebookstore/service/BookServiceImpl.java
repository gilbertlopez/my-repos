package org.lopez.ebookstore.service;

import java.util.List;

import org.lopez.ebookstore.dao.BookDao;
import org.lopez.ebookstore.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bookService")
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookDao bookDao;

	@Override
	public List<Book> findAllBooks() {
		return bookDao.findAllBooks();
	}

	@Override
	public Book findBookById(int id) {
		return bookDao.findBookById(id);
	}

	@Override
	public void addBook(Book book) {
		bookDao.addBook(book);	
	}

	@Override
	public void deleteBook(int id) {
		bookDao.deleteBook(id);;
	}

	@Override
	public void updateBook(Book book) {
		bookDao.updateBook(book);
	}

}
