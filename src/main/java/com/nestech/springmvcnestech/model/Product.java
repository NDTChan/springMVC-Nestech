package com.nestech.springmvcnestech.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
@EqualsAndHashCode
@Table(name = "product", schema = "shop")
public class Product {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "name", nullable = true, length = 225)
    private String name;
    @Basic
    @Column(name = "number", nullable = true)
    private Integer number;
}
