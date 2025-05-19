package com.bookclub1.service;

import java.util.List;

public interface GenericDao<T, ID> {
    T find(ID id);       // Make sure this method exists
    List<T> list();
    void save(T entity);
    void delete(ID id);
}


