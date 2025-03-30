package com.bookclub1.service;

import java.util.List;

public interface GenericDao<E, K> {
	void save(E entity);
	E find(K key);
	void update(E entity);
	void delete(K key);
    List<E> list();
  
}
