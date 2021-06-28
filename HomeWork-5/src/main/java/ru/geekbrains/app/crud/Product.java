package ru.geekbrains.app.crud;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public int getPrice() {
//        return price;
//    }
//
//    public void setPrice(int price) {
//        this.price = price;
//    }
//
    public Product() {
    }
//
//    public Products(Long id, String title, int price) {
//        this.id = id;
//        this.title = title;
//        this.price = price;
//    }
//
    public Product(String title, float price) {
        this.title = title;
        this.price = price;
    }
//
//    @Override
//    public String toString() {
//        return String.format("SimpleItem [id = %d, title = %s, price = %d]", id, title, price);
//    }
}

