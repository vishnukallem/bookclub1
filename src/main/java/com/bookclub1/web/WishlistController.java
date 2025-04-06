package com.bookclub1.web;

import com.bookclub1.dao.WishlistDao;
import com.bookclub1.model.WishlistItem;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/wishlist")
public class WishlistController {

    @Autowired
    private WishlistDao wishlistDao;

    @GetMapping
    public String showWishlist(Model model) {
        model.addAttribute("items", wishlistDao.findAll());
        return "wishlist/index";
    }

    @GetMapping("/new")
    public String showNewWishlistForm(Model model) {
        model.addAttribute("wishlistItem", new WishlistItem());
        return "wishlist/new";
    }

    @PostMapping
    public String addWishlistItem(@Valid @ModelAttribute WishlistItem wishlistItem,
                                  BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "wishlist/new";
        }
        wishlistDao.save(wishlistItem);
        return "redirect:/wishlist";
    }
}