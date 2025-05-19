package com.bookclub1.model;

public class Book {
    private String isbn;
    private String title;
    private String infoUrl;
    private int numOfPages;
    private String description;

    // Default constructor (no-argument constructor)
    public Book() {
    }

    // Constructor with all fields (optional, but good practice)
    public Book(String isbn, String title, String infoUrl, int numOfPages, String description) {
        this.isbn = isbn;
        this.title = title;
        this.infoUrl = infoUrl;
        this.numOfPages = numOfPages;
        this.description = description;
    }

    // Getter methods

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getInfoUrl() {
        return infoUrl;
    }

    public int getNumOfPages() {
        return numOfPages;
    }

    public String getDescription() {
        return description;
    }

    // Setter methods

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setInfoUrl(String infoUrl) {
        this.infoUrl = infoUrl;
    }

    public void setNumOfPages(int numOfPages) {
        this.numOfPages = numOfPages;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Book{" +
               "isbn='" + isbn + '\'' +
               ", title='" + title + '\'' +
               ", infoUrl='" + infoUrl + '\'' +
               ", numOfPages=" + numOfPages +
               ", description='" + description + '\'' +
               '}';
    }
}