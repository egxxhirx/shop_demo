package com.example.shopdemo.entity;

import java.util.Date;
import lombok.Data;

@Data
public class Color {
    private int id;
    private String color;
    private Date createdDate;
    private Date updatedDate;
}