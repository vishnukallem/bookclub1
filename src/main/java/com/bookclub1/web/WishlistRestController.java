package com.bookclub1.web;

import com.bookclub1.dao.WishlistDao;
import com.bookclub1.model.WishlistItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/wishlist")
public class WishlistRestController {

    @Autowired
    private WishlistDao wishListDao;

    // GET /api/wishlist - Get wishlist for the authenticated user
    @GetMapping
    public List<WishlistItem> getWishlist(Authentication authentication) {
        String username = authentication.getName(); // Get logged-in user's username
        return wishListDao.list(username); // Retrieve wishlist by username
    }
}
