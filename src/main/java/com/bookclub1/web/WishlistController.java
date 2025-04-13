package com.bookclub1.web;

import com.bookclub1.dao.WishlistDao;
import com.bookclub1.model.Wishlist;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/wishlist")
public class WishlistController {

    private WishlistDao wishlistDao;

    @Autowired
    private void setWishlistDao(WishlistDao wishlistDao) {
        this.wishlistDao = wishlistDao;
    }

    @GetMapping
    public String showWishlist(Model model) {
        List<Wishlist> wishlist = wishlistDao.list();
        model.addAttribute("wishlist", wishlist);
        return "wishlist/list";
    }

    @GetMapping("/new")
    public String showNewWishlistForm(Model model) {
        model.addAttribute("wishlist", new Wishlist());
        return "wishlist/new";
    }

    @PostMapping
    public String addWishlist(@Valid @ModelAttribute Wishlist wishlistItem,
                              BindingResult bindingResult, Model model) {

        // Print to console for debugging
        System.out.println(wishlistItem.toString());

        if (bindingResult.hasErrors()) {
            return "wishlist/new";
        }

        // Add the wishlist item if no errors
        wishlistDao.add(wishlistItem);

        return "redirect:/wishlist";
    }
}
