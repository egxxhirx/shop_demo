package com.example.shopdemo.entity;

import java.util.Date;
import lombok.Data;

@Data
public class CartItem {
    private int id;
    private int customerId;
    private int materialId;
    private int colorId;
    private int methodId;
    private int isDeleted;
    private Date createdDate;
    private Date updatedDate;
}