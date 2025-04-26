package com.bookclub1.web;

import com.bookclub1.model.WishlistItem;
import com.bookclub1.dao.WishlistDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/wishlist")
public class WishlistController {

    private WishlistDao wishlistDao;

    // ✅ Setter injection
    @Autowired
    public void setWishlistDao(WishlistDao wishlistDao) {
        this.wishlistDao = wishlistDao;
    }

    // ✅ Redirect from /wishlist to /wishlist/list
    @GetMapping
    public String redirectToWishlistList() {
        return "redirect:/wishlist/list";
    }

    // ✅ Show wishlist page (simplified without model attribute)
    @GetMapping("/list")
    public String showWishlist() {
        return "wishlist/list";
    }

    // ✅ Show new item form
    @GetMapping("/new")
    public String wishlistForm(Model model) {
        model.addAttribute("wishlistItem", new WishlistItem());
        return "wishlist/new";
    }

    // ✅ Handle submission of new item
    @PostMapping("/add")
    public String addWishlistItem(@Validated WishlistItem wishlistItem, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "wishlist/new";
        }

        wishlistDao.add(wishlistItem); // Use MongoDB custom method
        return "redirect:/wishlist/list";
    }
}