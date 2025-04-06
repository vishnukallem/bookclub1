package com.bookclub1.service;

import java.util.List;

/**
 * A generic CRUD DAO interface for any entity type E and key type K.
 *
 * @param <E> the type of the entity
 * @param <K> the type of the primary key (ID)
 */
public interface GenericCrudDao<E, K> {

    /**
     * Adds a new entity.
     * @param entity the entity to add
     */
    void add(E entity);

    /**
     * Updates an existing entity.
     * @param entity the entity to update
     */
    void update(E entity);

    /**
     * Removes an entity.
     * @param entity the entity to remove
     * @return true if successfully removed, false otherwise
     */
    boolean remove(E entity);

    /**
     * Lists all entities.
     * @return a list of entities
     */
    List<E> list();

    /**
     * Finds an entity by its key.
     * @param key the key to search for
     * @return the entity if found, or null
     */
    E find(K key);
}
