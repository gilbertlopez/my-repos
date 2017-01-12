package org.lopez.ebookstore.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.lopez.ebookstore.model.Book;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("bookDao")
@Transactional
public class BookDaoImpl extends AbstractDao<Integer, Book> implements BookDao {

	@Override
	public List<Book> findAllBooks() {
		CriteriaQuery<Book> query = getCriteriaBuilder().createQuery(Book.class);
		Root<Book> root = query.from(Book.class);
		return (List<Book>) getSession().createQuery(query).getResultList();
	}

	@Override
	public Book findBookById(int id) {
		return getByKey(id);
	}

	@Override
	public void addBook(Book book) {
		persist(book);
	}

	@Override
	public void deleteBook(int id) {
		Book book = findBookById(id);
		delete(book);
	}

}
