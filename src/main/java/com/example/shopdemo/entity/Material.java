package com.example.shopdemo.entity;

import java.util.Date;
import lombok.Data;

@Data
public class Material {
    private int id;
    private String material;
    private int price;
    private Date createdDate;
    private Date updatedDate;
}