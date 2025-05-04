package com.bookclub1.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bookclub1.model.Book;
import com.bookclub1.service.BookService;

@Controller
public class HomeController {

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String showHome(Model model) {
        // Replace this with actual list logic if implemented
        // List<Book> books = bookService.list(); // Uncomment if list() exists
        List<Book> books = List.of(); // Placeholder empty list

        System.out.println("Books List: " + books);

        if (books.isEmpty()) {
            System.out.println("Error: No books found!");
        }

        model.addAttribute("books", books);
        model.addAttribute("message", "Welcome to the Book Club!");

        return "home"; // Assumes a view template home.html exists
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
        Book book = bookService.find(id);  // Use BookService to find the book

        model.addAttribute("book", book);

        return "monthly-books/view";  // Ensure this template exists
    }
}
