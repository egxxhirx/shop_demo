package com.example.shopdemo.entity;

import java.util.Date;
import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "methods")
@Data
public class Method {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "method_name")
    private String method;

    @Column(name = "price")
    private int price;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "updated_date")
    private Date updatedDate;
}