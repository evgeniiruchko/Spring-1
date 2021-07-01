package ru.geekbrains.homework6.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
@Table (name = "costumers")
public class Costumer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "sex")
    private char sex;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "phone")
    private int phone;

    @ManyToMany
    @JoinTable(
            name = "orders",
            joinColumns = @JoinColumn(name = "costumer_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;

    public Costumer(String name, char sex, Date birthday, int phone) {
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
        this.phone = phone;
    }

    public Costumer(String name, int phone) {
        this.name = name;
        this.phone = phone;
    }

    public Costumer(String name, char sex, int phone) {
        this.name = name;
        this.sex = sex;
        this.phone = phone;
    }

    public Costumer(String name, Date birthday, int phone) {
        this.name = name;
        this.birthday = birthday;
        this.phone = phone;
    }

    public Costumer() {
    }
}
