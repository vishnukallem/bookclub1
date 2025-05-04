package com.bookclub1.service;

import com.bookclub1.model.Book;

public interface BookService {
    Book find(String isbn);  // Method signature for finding a book by ISBN
}
