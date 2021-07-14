package ru.geekbrains.app.homework9.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private Float price;

    @Column(name = "sale")
    private Boolean sale;

    @Column(name = "oldPrice")
    private Float oldPrice;

    public Product() {

    }
}
