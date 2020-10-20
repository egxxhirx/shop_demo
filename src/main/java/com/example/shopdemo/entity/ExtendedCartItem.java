package com.example.shopdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExtendedCartItem {

    @Id
    private int id;

    private String material;

    private int materialPrice;

    @Column(name = "color_name")
    private String color;

    @Column(name = "method_name")
    private String method;

    private int methodPrice;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "delete_flg")
    private int deleteFlg;

}