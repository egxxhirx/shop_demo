package com.example.shopdemo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "methods")
@Data
public class Method {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "method_name")
    private String method;

    @Column(name = "method_price")
    private int methodPrice;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "updated_date")
    private Date updatedDate;

    // @OneToMany(mappedBy = "method", cascade=CascadeType.ALL)
    // private List<Method> methods;
}