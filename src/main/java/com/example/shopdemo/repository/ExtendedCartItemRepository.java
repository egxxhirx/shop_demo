package com.example.shopdemo.repository;

import java.util.List;

import com.example.shopdemo.entity.ExtendedCartItem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ExtendedCartItemRepository extends JpaRepository<ExtendedCartItem, Integer>{
    
    @Query(value = 
    "SELECT t1.id, t2.material, t2.material_price, t3.color_name, t4.method_name, t4.method_price, t1.quantity, t1.delete_flg " +
    "FROM cart_items t1 JOIN materials t2 JOIN colors t3 JOIN methods t4 " +
    "ON t1.material_id = t2.id " +
    "AND t1.color_id = t3.id " +
    "AND t1.method_id = t4.id " +
    "WHERE t1.delete_flg = 0 " +
    "AND t1.customer_id = :customerId"
    , nativeQuery = true)
    List<ExtendedCartItem> findByCustomerId(@Param("customerId") int customerId);   

}