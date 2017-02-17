package org.lopez.ebookstore.controller;

import java.util.List;

import org.lopez.ebookstore.model.Book;
import org.lopez.ebookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AppController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/books")
	public String bookList(Model model) {
		List<Book> books = bookService.findAllBooks();
		model.addAttribute("books", books);
		return "books";
	}
	
	@GetMapping("/books/{id}")
	public String bookDetail(@PathVariable int id, Model model) {
		Book book = bookService.findBookById(id);
		model.addAttribute("book", book);
		return "bookDetail";
	}
}
