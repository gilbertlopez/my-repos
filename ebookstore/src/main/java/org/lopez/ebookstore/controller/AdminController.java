package org.lopez.ebookstore.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.lopez.ebookstore.model.Book;
import org.lopez.ebookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private BookService bookService;

	@GetMapping
	public String adminHome() {
		return "admin";
	}
	
	@GetMapping("/bookInventory")
	public String bookInventory(Model model) {
		List<Book> books = bookService.findAllBooks();
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
	String saveBook(@ModelAttribute("book") Book book, HttpServletRequest request) {
		bookService.addBook(book, request);	
		return "redirect:/admin/bookInventory";
	}
	
	@GetMapping("/deleteBook/{id}")
	String deleteBook(@PathVariable int id, HttpServletRequest request) {
		bookService.deleteBook(id, request);
		return "redirect:/admin/bookInventory";
	}
	
	@GetMapping("/editBook/{id}")
	public String editBook(@PathVariable int id, Model model) {
		Book book = bookService.findBookById(id);
		model.addAttribute("book", book);
		return "editBook";
	}
	
	@PostMapping("/updateBook")
	public String updateBook(@ModelAttribute Book book, HttpServletRequest request) {
		bookService.updateBook(book, request);
		return "redirect:/admin/bookInventory";
	}
}
