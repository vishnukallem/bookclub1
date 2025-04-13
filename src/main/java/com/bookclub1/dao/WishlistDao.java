
package com.bookclub1.dao;

import com.bookclub1.model.Wishlist;
import java.util.List;

public interface WishlistDao {

    void add(Wishlist entity);  // Save or add a Wishlist
    void update(Wishlist entity);  // Update an existing Wishlist
    boolean remove(Wishlist entity);  // Remove a Wishlist
    List<Wishlist> list();  // List all Wishlists
    Wishlist find(Long key);  // Find a Wishlist by ID
    void deleteById(Long id);  // Delete Wishlist by ID
    List<Wishlist> findAll();  // Get all Wishlists
    void save(Wishlist entity);  // Method to save a Wishlist
}