package com.example.shopdemo.entity;

import java.util.Date;
import lombok.Data;

@Data
public class Method {
    private int id;
    private String method;
    private int price;
    private Date createdDate;
    private Date updatedDate;
}