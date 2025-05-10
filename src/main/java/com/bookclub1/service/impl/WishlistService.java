package com.bookclub1.service.impl;

import com.bookclub1.dao.WishlistDao;
import com.bookclub1.model.WishlistItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishlistService {

    // Inject WishlistDao
    @Autowired
    private WishlistDao wishlistDao;

    /**
     * Fetches a wishlist item by its ID.
     *
     * @param id The ID of the wishlist item.
     * @return The WishlistItem object or null if not found.
     */
    public WishlistItem findById(String id) {
        return wishlistDao.findById(id);  // Ensure this method is defined in your WishlistDao
    }

    /**
     * Updates a wishlist item.
     *
     * @param wishlistItem The WishlistItem object with updated data.
     */
    public void update(WishlistItem wishlistItem) {
        wishlistDao.update(wishlistItem);  // Ensure this method is defined in your WishlistDao
    }

    /**
     * Removes a wishlist item.
     *
     * @param id The ID of the wishlist item to be removed.
     * @return true if successfully removed, false otherwise.
     */
    public boolean remove(String id) {
        return wishlistDao.remove(id);  // Ensure this method is defined in your WishlistDao
    }

    /**
     * Fetches all wishlist items for a given user.
     *
     * @param username The username to fetch wishlist items for.
     * @return A list of WishlistItem objects.
     */
    public List<WishlistItem> list(String username) {
        return wishlistDao.list(username);  // Ensure this method is defined in your WishlistDao
    }
}
