package com.bookclub1.web;

import com.bookclub1.model.Book;  // Ensure this import points to the correct package
import com.bookclub1.service.impl.RestBookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jayway.jsonpath.JsonPath;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

@Controller
public class BookController {

    @Autowired
    private RestBookDao restBookDao;

    @GetMapping("/list")
    public String list(@RequestParam("isbn") String isbn, Model model) {
        // Step 1: Call the getBooksDoc method to get the book data from OpenLibrary API
        String jsonBooklist = restBookDao.getBooksDoc(isbn); // Get the raw JSON response

        // Step 2: Parse the JSON response
        // Use JsonPath to extract the book details. Assume we get a map of book details.
        Map<String, Object> bookData = JsonPath.parse(jsonBooklist).read("$"); // Extracting root

        // Step 3: Convert the book data into a list of Book objects
        List<Book> books = new ArrayList<>();
        for (Map.Entry<String, Object> entry : bookData.entrySet()) {
            // You can adjust this part based on the actual JSON structure returned
            @SuppressWarnings("unchecked")
            Map<String, Object> bookInfo = (Map<String, Object>) entry.getValue();
            @SuppressWarnings("unused")
			String isbnValue = (String) bookInfo.get("bib_key");
            @SuppressWarnings("unused")
			String title = (String) bookInfo.get("title");
            @SuppressWarnings("unused")
			String description = (String) bookInfo.get("description");
            @SuppressWarnings("unused")
			String infoUrl = (String) bookInfo.get("url");
            @SuppressWarnings("unused")
			int numOfPages = Integer.parseInt((String) bookInfo.get("number_of_pages")); // example

            // Create a new Book object and add it to the list
            books.add(new Book());
        }

        // Step 4: Add the books list to the model to display in the view
        model.addAttribute("books", books);

        return "bookList"; // The name of the view template
    }
}
