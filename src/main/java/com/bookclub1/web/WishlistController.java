package com.bookclub1.web;

import com.bookclub1.dao.WishlistDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/wishlist")
public class WishlistController {

    @Autowired
    private WishlistDao wishlistDao;

    /**
     * Removes a wishlist item by its ID.
     *
     * @param id The ID of the wishlist item to remove.
     * @return A redirect to the wishlist route after removal.
     */
    @RequestMapping(method = RequestMethod.GET, path = "/remove/{id}")
    public String removeWishlistItem(@PathVariable("id") String id) {
        // Call the remove method in the wishlistDao to remove the item by its ID
        boolean removed = wishlistDao.remove(id);

        // Check if the removal was successful (you can add error handling as needed)
        if (!removed) {
            // Optionally, you can add an error message to the model if the item could not be removed
            // model.addAttribute("error", "Failed to remove the item.");
            return "error"; // You can replace with an error page if necessary
        }

        // Redirect to the wishlist route after removing the item
        return "redirect:/wishlist"; // Redirect to the wishlist page or route
    }
}
