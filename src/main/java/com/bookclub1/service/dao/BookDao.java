package com.bookclub1.service.dao;

import java.util.List;
import com.bookclub1.model.Book;
import com.bookclub1.service.GenericDao;

public interface BookDao extends GenericDao<Book, String> {
    // Add any additional methods specific to BookDao if needed
    List<Book> list(); // List method for books
    Book find(String isbn); // Find method for finding a book by ISBN
}