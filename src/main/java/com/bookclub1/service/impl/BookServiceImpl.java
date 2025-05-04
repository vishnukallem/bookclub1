package com.bookclub1.service.impl;

import com.bookclub1.model.Book;
import com.bookclub1.service.BookService;
import com.jayway.jsonpath.JsonPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private RestBookDao restBookDao;

    @Override
    public Book find(String isbn) {
        // Add prefix "ISBN:" because OpenLibrary returns keys in this format
        String key = "ISBN:" + isbn;

        // Fetch JSON string
        String jsonBooklist = restBookDao.getBooksDoc(key);

        if (jsonBooklist == null || jsonBooklist.isEmpty()) {
            return null;
        }

        // Parse the JSON to extract the nested book object
        Map<String, Object> bookMap = JsonPath.parse(jsonBooklist).read("$." + key);

        if (bookMap == null) {
            return null;
        }

        // Extract fields using safe casting
        String title = bookMap.containsKey("title") ? (String) bookMap.get("title") : "N/A";

        // Handle the description which could be a nested object or string
        String description = "N/A";  // Default value
        if (bookMap.containsKey("description")) {
            Object desc = bookMap.get("description");
            if (desc instanceof Map) {
                description = (String) ((Map<?, ?>) desc).get("value");
            } else if (desc instanceof String) {
                description = (String) desc;
            }
        }

        // Extract infoUrl and number of pages safely
        @SuppressWarnings("unused")
		String infoUrl = bookMap.containsKey("url") ? (String) bookMap.get("url") : "N/A";
        @SuppressWarnings("unused")
		int numberOfPages = bookMap.containsKey("number_of_pages") ? 
                            ((Number) bookMap.get("number_of_pages")).intValue() : 0;

        // Extract authors list and get the first author
        @SuppressWarnings("unchecked")
		List<Map<String, Object>> authorsList = (List<Map<String, Object>>) bookMap.get("authors");
        String author = "N/A";  // Default value
        if (authorsList != null && !authorsList.isEmpty()) {
            Map<String, Object> firstAuthor = authorsList.get(0);
            if (firstAuthor != null && firstAuthor.containsKey("name")) {
                author = (String) firstAuthor.get("name");
            }
        }

        // Extract subjects list and get the first subject
        @SuppressWarnings("unchecked")
		List<Map<String, Object>> subjectsList = (List<Map<String, Object>>) bookMap.get("subjects");
        String subject = "N/A";  // Default value
        if (subjectsList != null && !subjectsList.isEmpty()) {
            Map<String, Object> firstSubject = subjectsList.get(0);
            if (firstSubject != null && firstSubject.containsKey("name")) {
                subject = (String) firstSubject.get("name");
            }
        }

        // Construct and return the Book object
        return new Book(isbn, title, description, author, subject);
    }
}
