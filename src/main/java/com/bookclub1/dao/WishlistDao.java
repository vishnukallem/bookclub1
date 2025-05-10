package com.bookclub1.dao;

import com.bookclub1.model.WishlistItem;
import java.util.List;

public interface WishlistDao {
    WishlistItem findById(String id);
    void update(WishlistItem wishlistItem);
    boolean remove(String id);
    List<WishlistItem> list(String username);
}
