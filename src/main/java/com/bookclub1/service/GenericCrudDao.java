package com.bookclub1.service;

import java.util.List;

public interface GenericCrudDao<E, K> {
    void add(E entity);
    void update(E entity);
    boolean remove(K key);         // Remove an entity using a key of type K
    List<E> list(K key);           // Return a list of entities filtered by a key of type K
    E find(K key);                 // Find and return a single entity by key
}
