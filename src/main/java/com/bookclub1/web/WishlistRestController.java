package com.bookclub1.web;

import com.bookclub1.dao.WishlistDao;
import com.bookclub1.model.WishlistItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/wishlist", produces = "application/json")
@CrossOrigin(origins = "*")  // Allow all origins
@io.swagger.v3.oas.annotations.tags.Tag(name = "Wishlist API", description = "Operations related to the wishlist") // Optional: for better documentation in Swagger
public class WishlistRestController {

    private WishlistDao wishlistDao;

    @Autowired
    public void setWishlistDao(WishlistDao wishlistDao) {
        this.wishlistDao = wishlistDao;
    }

    @GetMapping
    public List<WishlistItem> showWishlist() {
        return wishlistDao.list();  // Fetch the list of wishlist items
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public WishlistItem findById(@PathVariable String id) {
        return wishlistDao.find(id);  // Find a specific wishlist item by its ID
    }
}
