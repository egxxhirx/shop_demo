package com.example.shopdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.shopdemo.entity.Method;

@Repository
public interface MethodRepository extends JpaRepository<Method, Integer>{
    
}