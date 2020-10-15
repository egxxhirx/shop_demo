package com.example.shopdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.shopdemo.entity.Color;

@Repository
public interface ColorRepository extends JpaRepository<Color, Integer>{
    
}