

package com.bookclub1.service.impl;

import com.bookclub1.model.BookOfTheMonth;
import com.bookclub1.service.dao.BookOfTheMonthDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("bookOfTheMonthDao")
public class MongoBookOfTheMonthDao implements BookOfTheMonthDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void add(BookOfTheMonth entity) {
        mongoTemplate.insert(entity);
    }

    @Override
    public void update(BookOfTheMonth entity) {
        mongoTemplate.save(entity);
    }

    @Override
    public boolean remove(String id) {
        BookOfTheMonth existing = mongoTemplate.findById(id, BookOfTheMonth.class);
        if (existing != null) {
            mongoTemplate.remove(existing);
            return true;
        }
        return false;
    }

    @Override
    public List<BookOfTheMonth> list(String key) {
        // `key` is ignored as we just return all entries
        return mongoTemplate.findAll(BookOfTheMonth.class);
    }

    @Override
    public BookOfTheMonth find(String id) {
        return mongoTemplate.findById(id, BookOfTheMonth.class);
    }
}