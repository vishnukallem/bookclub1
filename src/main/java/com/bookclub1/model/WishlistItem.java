package com.bookclub1.model;

import org.springframework.data.annotation.Id;
import jakarta.validation.constraints.NotBlank;

public class WishlistItem {

    @Id
    private String id;  // The id property with @Id annotation

    @NotBlank(message = "ISBN cannot be blank")
    private String isbn;

    @NotBlank(message = "Title cannot be blank")
    private String title;

    @NotBlank(message = "Description cannot be blank")
    private String description;

    // Constructors
    public WishlistItem() {}

    public WishlistItem(String isbn, String title, String description) {
        this.isbn = isbn;
        this.title = title;
        this.description = description;
    }

    // Getter for the id property
    public String getId() {
        return id; // Returns the id of type String
    }

    // Setter for id
    public void setId(String id) {
        this.id = id; // Sets the id property
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Override toString method to include id property using String.format
    @Override
    public String toString() {
        return String.format("WishlistItem{id=%s, isbn=%s, title=%s, description=%s}", id, isbn, title, description);
    }
}
