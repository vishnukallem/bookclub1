// MongoWishlistDao.java
package com.bookclub1.service.impl;

import com.bookclub1.dao.WishlistDao;
import com.bookclub1.model.WishlistItem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class MongoWishlistDao implements WishlistDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    // Other methods like list and update...

    
    public boolean remove(String id) {
        // Create a query to find the wishlist item by its id
        Query query = new Query(Criteria.where("id").is(id));

        // Perform the remove operation
        WishlistItem wishlistItem = mongoTemplate.findAndRemove(query, WishlistItem.class);

        // Return true if the item was removed, otherwise false
        return wishlistItem != null;
    }

	@Override
	public List<WishlistItem> list(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WishlistItem findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(WishlistItem wishlistItem) {
		// TODO Auto-generated method stub
		
	}
}
