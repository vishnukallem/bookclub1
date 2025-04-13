package com.bookclub1.service.impl;

import com.bookclub1.dao.WishlistDao;
import com.bookclub1.model.Wishlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository("wishlistDao")
public abstract class WishlistDaoImpl implements WishlistDao {

    @Autowired
    private MongoTemplate mongoTemplate;
    

    public void add(Wishlist entity) {
        mongoTemplate.save(entity);
    }

    
    public void update(Wishlist entity) {
        mongoTemplate.save(entity);
    }

   
    public boolean remove(Wishlist entity) {
        mongoTemplate.remove(entity);
        return true;
    }


    public List<Wishlist> list() {
        return mongoTemplate.findAll(Wishlist.class);
    }

    
    public Wishlist find(Long key) {
        return mongoTemplate.findById(key, Wishlist.class);
    }

    
    public void deleteById(Long id) {
        Wishlist wishlist = find(id);
        if (wishlist != null) {
            mongoTemplate.remove(wishlist);
        }
    }
}
