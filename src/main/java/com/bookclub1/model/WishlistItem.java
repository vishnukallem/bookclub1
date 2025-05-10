package com.bookclub1.model;

public class WishlistItem {

    private String id;         // existing fields
    private String title;
    private String author;
    private String isbn;
    private String description;
    
    // New field added
    private String username;   // Added username field

    // Constructor
    public WishlistItem() {
    }

    // Getters and Setters for all fields

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Getter and Setter for the new username field
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Overriding the toString() method to include the username
    @Override
    public String toString() {
        return "WishlistItem{" +
               "id='" + id + '\'' +
               ", title='" + title + '\'' +
               ", author='" + author + '\'' +
               ", isbn='" + isbn + '\'' +
               ", description='" + description + '\'' +
               ", username='" + username + '\'' +  // Include username in toString()
               '}';
    }
}
