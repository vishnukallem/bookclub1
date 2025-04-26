package com.bookclub1.service.impl;

import com.bookclub1.dao.WishlistDao;
import com.bookclub1.model.WishlistItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("wishlistDao")
public class MongoWishlistDao implements WishlistDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    // Implements the required 'add' method from GenericCrudDao
    @Override
    public void add(WishlistItem item) {
        mongoTemplate.save(item);
    }

    @Override
    public void update(WishlistItem item) {
        mongoTemplate.save(item); // Same as add for MongoDB
    }

    @Override
    public boolean remove(WishlistItem item) {
        return mongoTemplate.remove(item).wasAcknowledged();
    }

    @Override
    public List<WishlistItem> list() {
        return mongoTemplate.findAll(WishlistItem.class);
    }

    @Override
    public WishlistItem find(String id) {
        return mongoTemplate.findById(id, WishlistItem.class);
    }

	@Override
	public Object findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(WishlistItem wishlist) {
		// TODO Auto-generated method stub
		
	}
}