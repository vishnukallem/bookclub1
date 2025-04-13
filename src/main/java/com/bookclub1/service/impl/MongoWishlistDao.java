package com.bookclub1.service.impl;
import com.bookclub1.dao.WishlistDao;
import com.bookclub1.model.Wishlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("wishlistDao")
public class MongoWishlistDao implements WishlistDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void add(Wishlist entity) {
        mongoTemplate.save(entity);
    }

    @Override
    public void update(Wishlist entity) {
        mongoTemplate.save(entity);
    }

    @Override
    public boolean remove(Wishlist entity) {
        mongoTemplate.remove(entity);
        return true;
    }

    @Override
    public List<Wishlist> list() {
        return mongoTemplate.findAll(Wishlist.class);
    }

    @Override
    public Wishlist find(Long key) {
        return mongoTemplate.findById(key, Wishlist.class);
    }

    @Override
    public void deleteById(Long id) {
        Wishlist wishlist = find(id);
        if (wishlist != null) {
            mongoTemplate.remove(wishlist);
        }
    }
    @Override
    public List<Wishlist> findAll() {
        return mongoTemplate.findAll(Wishlist.class);  // Get all Wishlists from MongoDB
    }

    @Override
    public void save(Wishlist entity) {
        mongoTemplate.save(entity);  // Save the Wishlist entity using MongoTemplate
    }
}
