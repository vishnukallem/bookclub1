package com.bookclub1.service;

import java.util.List;

public interface GenericCrudDao<E, K> {

    // Add a new entity
    void add(E entity);

    // Update an existing entity
    void update(E entity);

    // Remove an entity (returns true if successful)
    boolean remove(E entity);

    // Return a list of all entities
    List<E> list();

    // Find an entity by its key
    E find(K key);
}
