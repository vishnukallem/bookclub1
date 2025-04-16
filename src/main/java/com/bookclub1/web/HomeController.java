package com.bookclub1.web;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bookclub1.model.Book;
import com.bookclub1.service.impl.MemBookDao;

@Controller
public class HomeController {

    @GetMapping("/")
    public String showHome(Model model) {
        // Create an instance of MemBookDao
        MemBookDao bookDao = new MemBookDao();

        // Retrieve the list of books
        List<Book> books = bookDao.list();
        System.out.println("Books List: " + books); 

     if (books.isEmpty()) {
    	 System.out.println("Error: No books found!"); 
     }
        model.addAttribute("books", books);
        model.addAttribute("message", "Welcome to the Book Club!");

        return "home";  // Ensure index.html is updated to display books
    }

    @GetMapping("/about")
    public String showAboutUs(Model model) {
        model.addAttribute("message", "About Us - Learn more about our book club.");
        return "about";  
    }

    @GetMapping("/contact")
    public String showContactUs(Model model) {
        model.addAttribute("message", "Contact Us - Get in touch with us.");
        return "contact";  
    }

    // New method to retrieve a book by ID
    @GetMapping("/{id}")
    public String getMonthlyBook(@PathVariable("id") String id, Model model) {
        // Create an instance of MemBookDao
        MemBookDao booksDao = new MemBookDao();

        // Find the book by ID
        Book book = booksDao.find(id);

        // Add the book to the model
        model.addAttribute("book", book);

        // Return the monthly book view
        return "monthly-books/view";  // Ensure this matches your template path
    }
}