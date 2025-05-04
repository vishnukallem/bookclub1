package com.bookclub1.model;

public class Book {
    private String isbn;
    private String title;
    private String description;
    private String author;
    private String subject;

    // ✅ Constructor with 5 parameters
    public Book(String isbn, String title, String description, String author, String subject) {
        this.isbn = isbn;
        this.title = title;
        this.description = description;
        this.author = author;
        this.subject = subject;
    }

    // ✅ Default constructor (optional, but helpful)
    public Book() {}

    // ✅ Getters and setters (generate using IDE or manually)
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }
}
