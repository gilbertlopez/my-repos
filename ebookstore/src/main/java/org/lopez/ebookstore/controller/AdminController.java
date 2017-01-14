package org.lopez.ebookstore.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.lopez.ebookstore.dao.BookDao;
import org.lopez.ebookstore.model.Book;
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
	String saveBook(@ModelAttribute("book") Book book, HttpServletRequest request) {
		bookDao.addBook(book);
		
		MultipartFile bookImage = book.getBookImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "WEB-INF/resources/images/" + book.getId() +".png");
		if(bookImage != null && !bookImage.isEmpty()) {
			try {
				bookImage.transferTo(new File(path.toString()));
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("Product image saving failed", e);
			}
		}
		return "redirect:/admin/bookInventory";
	}
	
	@GetMapping("/deleteBook/{id}")
	String deleteBook(@PathVariable int id) {
		bookDao.deleteBook(id);
		return "redirect:/admin/bookInventory";
	}
}
