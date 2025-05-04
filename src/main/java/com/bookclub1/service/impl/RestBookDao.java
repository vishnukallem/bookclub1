package com.bookclub1.service.impl;

import com.bookclub1.service.BookDao;  // Ensure BookDao interface exists and is correctly defined
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

@Repository
public class RestBookDao implements BookDao {

    private final RestTemplate restTemplate = new RestTemplate();

    /**
     * Fetches book data from OpenLibrary API using a string of ISBN numbers.
     *
     * @param isbnString comma-separated string of ISBNs (e.g., "ISBN:0451526538,ISBN:9780140449136")
     * @return JSON string response from OpenLibrary, or null if an error occurs.
     */
    @Override
    public String getBooksDoc(String isbnString) {
        // Build the API URL
        String url = UriComponentsBuilder
                .fromHttpUrl("https://openlibrary.org/api/books")
                .queryParam("bibkeys", isbnString)
                .queryParam("format", "json")
                .queryParam("jscmd", "data")
                .toUriString();

        // Log the constructed URL
        System.out.println("API URL: " + url);

        try {
            // Send GET request to OpenLibrary API
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

            // Log the API response
            System.out.println("API Response: " + response.getBody());

            return response.getBody();
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            // Log 4xx or 5xx HTTP errors
            System.err.println("HTTP error fetching book data: " + e.getStatusCode() + " - " + e.getMessage());
        } catch (Exception e) {
            // Log unexpected errors
            System.err.println("Unexpected error fetching book data: " + e.getMessage());
        }

        return null;
    }
}
