package org.lopez.ebookstore.controller;

import java.util.List;

import org.lopez.ebookstore.dao.BookDao;
import org.lopez.ebookstore.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private BookDao bookDao;

	@GetMapping
	public String adminHome() {
		return "admin";
	}
	
	@GetMapping("/bookInventory")
	public String bookInventory(Model model) {
		List<Book> books = bookDao.findAllBooks();
		model.addAttribute("books", books);
		return "bookInventory";
	}
	
	@GetMapping("/addBook")
	public String addBook(Model model) {
		Book book = new Book();
		model.addAttribute("book", book);
		return "addBook";
	}
	
	@PostMapping("/saveBook")
	String saveBook(@ModelAttribute("book") Book book) {
		bookDao.addBook(book);
		return "redirect:/admin/bookInventory";
	}
}
