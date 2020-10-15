package com.example.shopdemo.entity;

import java.util.Date;
import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cart_items")
@Data
public class CartItem {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "material_id")
    private int materialId;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "color_id")
    private int colorId;

    @Column(name = "method_id")
    private int methodId;

    @Column(name = "delete_flg")
    private int isDeleted;
    
    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "updated_date")
    private Date updatedDate;
}