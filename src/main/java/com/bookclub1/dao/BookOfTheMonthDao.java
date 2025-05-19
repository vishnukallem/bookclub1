package com.bookclub1.dao;

import com.bookclub1.model.BookOfTheMonth;
import com.bookclub1.service.GenericCrudDao;

public interface BookOfTheMonthDao extends GenericCrudDao<BookOfTheMonth, String> {
    // Add custom query methods if needed
}
