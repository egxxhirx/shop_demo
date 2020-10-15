package com.example.shopdemo.form;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class CartItemForm implements Serializable {

    private static final long serialVersionUID = 1L;


    private int id;

    private int customerId;

    private int materialId;

    private int colorId;

    private int methodId;

    private int quantity;

    private int isDeleted;
   
    private Date createdDate;

    private Date updatedDate;
}