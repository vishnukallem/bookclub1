package com.bookclub1.service.impl;

import com.bookclub1.model.Book;
import com.bookclub1.service.dao.BookDao;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class RestBookDao implements BookDao {


    private final RestTemplate restTemplate = new RestTemplate();
    private final HttpHeaders headers;

    public RestBookDao() {
        this.headers = new HttpHeaders();
        this.headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
    }

    private Object getBooksDoc(String isbnString) {
        String openLibraryUrl = "https://openlibrary.org/api/books";

        URI uri = UriComponentsBuilder.fromHttpUrl(openLibraryUrl)
                .queryParam("bibkeys", isbnString)
                .queryParam("format", "json")
                .queryParam("jscmd", "data")
                .build()
                .toUri();

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);

        String jsonBooklist = response.getBody();
        return Configuration.defaultConfiguration().jsonProvider().parse(jsonBooklist);
    }

    @Override
    public List<Book> list() {
        String[] isbnKeys = {"0451526538", "9780140449136", "9780141182803"};
        String isbnParam = String.join(",", java.util.Arrays.stream(isbnKeys).map(isbn -> "ISBN:" + isbn).toArray(String[]::new));
        return list(isbnParam); // Delegate to overloaded method
    }

    // ✅ Overloaded method that accepts a custom ISBN string
    public List<Book> list(String isbnParam) {
        Object jsonResponse = getBooksDoc(isbnParam);
        List<Book> books = new ArrayList<>();

        String[] isbnKeysWithPrefix = isbnParam.split(",");

        for (String isbnKeyWithPrefix : isbnKeysWithPrefix) {
            try {
                Map<String, Object> bookData = JsonPath.read(jsonResponse, "$['" + isbnKeyWithPrefix + "']");

                String isbn = isbnKeyWithPrefix.replace("ISBN:", "");
                String title = bookData.getOrDefault("title", "N/A").toString();
                String infoUrl = bookData.getOrDefault("url", "#").toString();
                int pages = (bookData.containsKey("number_of_pages"))
                        ? ((Number) bookData.get("number_of_pages")).intValue()
                        : 0;

                String description = "No description available.";
                if (bookData.containsKey("description")) {
                    Object desc = bookData.get("description");
                    if (desc instanceof String) {
                        description = desc.toString();
                    } else if (desc instanceof Map) {
                        @SuppressWarnings("unchecked")
                        Map<String, Object> descMap = (Map<String, Object>) desc;
                        description = descMap.getOrDefault("value", description).toString();
                    }
                }

                Book book = new Book();
                book.setIsbn(isbn);
                book.setTitle(title);
                book.setInfoUrl(infoUrl);
                book.setNumOfPages(pages);
                book.setDescription(description);

                books.add(book);
            } catch (Exception e) {
                System.err.println("Error parsing book " + isbnKeyWithPrefix + ": " + e.getMessage());
            }
        }

        return books;
    }

    @Override
    public Book find(String isbn) {
        if (isbn == null || isbn.trim().isEmpty() || !isbn.matches("\\d{9}[\\dXx]|\\d{13}")) {
            System.err.println("Invalid ISBN input: " + isbn);
            return null;
        }

        String isbnKey = "ISBN:" + isbn;
        Object jsonResponse = getBooksDoc(isbnKey);

        try {
            Map<String, Object> bookData = JsonPath.read(jsonResponse, "$['" + isbnKey + "']");

            String title = bookData.getOrDefault("title", "N/A").toString();
            String infoUrl = bookData.getOrDefault("url", "#").toString();
            int pages = (bookData.containsKey("number_of_pages"))
                    ? ((Number) bookData.get("number_of_pages")).intValue()
                    : 0;

            String description = "No description available.";
            if (bookData.containsKey("description")) {
                Object desc = bookData.get("description");
                if (desc instanceof String) {
                    description = desc.toString();
                } else if (desc instanceof Map) {
                    @SuppressWarnings("unchecked")
                    Map<String, Object> descMap = (Map<String, Object>) desc;
                    description = descMap.getOrDefault("value", description).toString();
                }
            }

            Book book = new Book();
            book.setIsbn(isbn);
            book.setTitle(title);
            book.setInfoUrl(infoUrl);
            book.setNumOfPages(pages);
            book.setDescription(description);

            return book;
        } catch (Exception e) {
            System.err.println("Error fetching book for ISBN " + isbnKey + ": " + e.getMessage());
            return null;
        }
    }

    @Override
    public void save(Book book) {
        throw new UnsupportedOperationException("Save operation not supported in RestBookDao");
    }

    public void update(Book book) {
        throw new UnsupportedOperationException("Update operation not supported in RestBookDao");
    }

    @Override
    public void delete(String isbn) {
        throw new UnsupportedOperationException("Delete operation not supported in RestBookDao");
    }
}