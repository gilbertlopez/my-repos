package org.lopez.ebookstore.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.lopez.ebookstore.dao.BookDao;
import org.lopez.ebookstore.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("bookService")
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookDao bookDao;
	
	@Autowired
	private FileUtil fileUtil;

	@Override
	@Transactional
	public List<Book> findAllBooks() {
		return bookDao.findAllBooks();
	}

	@Override
	@Transactional
	public Book findBookById(int id) {
		return bookDao.findBookById(id);
	}

	@Override
	@Transactional
	public void addBook(Book book) {
		bookDao.addBook(book);	
	}

	@Override
	@Transactional
	public void deleteBook(int id) {
		bookDao.deleteBook(id);;
	}

	@Override
	@Transactional
	public void updateBook(Book book) {
		bookDao.updateBook(book);
	}

	@Override
	@Transactional
	public void addBook(Book book, HttpServletRequest request) {
		bookDao.addBook(book);
		if (book.getBookImage() != null && !book.getBookImage().isEmpty())
			fileUtil.saveBookImage(book.getBookImage(), book.getId(), request);	
	}
	
	@Override
	@Transactional
	public void updateBook(Book book, HttpServletRequest request) {
		bookDao.updateBook(book);
		if (book.getBookImage() != null && !book.getBookImage().isEmpty())
			fileUtil.saveBookImage(book.getBookImage(), book.getId(), request);	
	}
	@Override
	@Transactional
	public void deleteBook(int id, HttpServletRequest request) {
		bookDao.deleteBook(id);
		fileUtil.deleteBookImage(id, request);	
	}
}
