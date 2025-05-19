

package com.bookclub1.service.dao;

import com.bookclub1.model.BookOfTheMonth;
import com.bookclub1.service.GenericCrudDao;

public interface BookOfTheMonthDao extends GenericCrudDao<BookOfTheMonth, String> {
    // No need to define methods explicitly – inherited from GenericCrudDao
}