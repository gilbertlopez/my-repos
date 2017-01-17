package org.lopez.ebookstore.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	private Path path;
	
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
		bookService.addBook(book);
		
		MultipartFile bookImage = book.getBookImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "WEB-INF/resources/images/" + book.getId() +".png");
		if(bookImage != null && !bookImage.isEmpty()) {
			try {
				bookImage.transferTo(new File(path.toString()));
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("Book image saving failed", e);
			}
		}
		return "redirect:/admin/bookInventory";
	}
	
	@GetMapping("/deleteBook/{id}")
	String deleteBook(@PathVariable int id, HttpServletRequest request) {
		bookService.deleteBook(id);
		
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "WEB-INF/resources/images/" + id + ".png");
		
		try {
			Files.deleteIfExists(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
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
		MultipartFile bookImage = book.getBookImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "WEB-INF/resources/images/" + book.getId() + ".png");
		
		if(bookImage != null && !bookImage.isEmpty()) {
			try {
				bookImage.transferTo(new File(path.toString()));
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
				throw new RuntimeException("Book image saving failed", e);
			}
		}
		
		bookService.updateBook(book);
		return "redirect:/admin/bookInventory";
	}
}
