package com.bookclub1.dao;

import java.util.List;

public interface GenericDao<T> {
    T save(T t);
    List<T> list();
    // more methods...
}
