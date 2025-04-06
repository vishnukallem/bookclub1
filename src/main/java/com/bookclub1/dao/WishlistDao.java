package com.bookclub1.dao;

import com.bookclub1.model.WishlistItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface WishlistDao extends JpaRepository<WishlistItem, Long> {

 

    // Custom method to delete a WishlistItem by its ID
    void deleteById(Long id);

}
