package com.example.shopdemo.entity;

import java.util.Date;
import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
}