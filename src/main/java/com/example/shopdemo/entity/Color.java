package com.example.shopdemo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "colors")
@Data
public class Color {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "color_name")
    private String color;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "updated_date")
    private Date updatedDate;

    // @OneToMany(mappedBy = "color", cascade=CascadeType.ALL)
    // private List<Color> colors;
}