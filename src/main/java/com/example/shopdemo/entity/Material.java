package com.example.shopdemo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "materials")
@Data
public class Material {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "material")
    private String material;

    @Column(name = "material_price")
    private int materialPrice;

    @Column(name = "discription")
    private String discription;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "updated_date")
    private Date updatedDate;

    // @OneToMany(mappedBy = "material", cascade=CascadeType.ALL)
    // private List<Material> materials;

}