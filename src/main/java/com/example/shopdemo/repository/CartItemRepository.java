package com.example.shopdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.shopdemo.entity.CartItem;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Integer>{

    @Transactional
    @Modifying
    @Query (value = "UPDATE cart_items c set quantity =:quantity WHERE c.id =:id", nativeQuery = true)
     public Integer updateCartItem (@Param ("quantity")int quantity, @Param ("id")int id);

}