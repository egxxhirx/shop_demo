package com.example.shopdemo.entity;

import java.util.Date;
import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "materials")
@Data
public class Material {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "material")
    private String material;

    @Column(name = "price")
    private int price;

    @Column(name = "discription")
    private String discription;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "updated_date")
    private Date updatedDate;
}