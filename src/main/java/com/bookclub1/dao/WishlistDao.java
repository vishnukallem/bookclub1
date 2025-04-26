package com.bookclub1.dao;

import com.bookclub1.model.WishlistItem;
import com.bookclub1.service.GenericCrudDao;

import org.springframework.stereotype.Repository;

@Repository("wishlistDao")
public interface WishlistDao extends GenericCrudDao<WishlistItem, String> {

	Object findAll();
    // No need to declare deleteById here unless you want a custom method

	void save(WishlistItem wishlist);
}