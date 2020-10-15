package com.example.shopdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.shopdemo.entity.Material;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Integer>{
    
}