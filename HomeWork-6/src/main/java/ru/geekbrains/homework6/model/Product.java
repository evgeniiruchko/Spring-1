package ru.geekbrains.homework6.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Data
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private float price;

    public Product() {
    }

    public Product(String title, float price) {
        this.title = title;
        this.price = price;
    }

    @ManyToMany
    @JoinTable (
            name = "orders",
            joinColumns = @JoinColumn(name ="product_id"),
            inverseJoinColumns = @JoinColumn(name = "costumer_id"))
    private List<Costumer> costumers;
}
