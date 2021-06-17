package ru.geekbrains.spring.context;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class ProductRepo implements ProductsRepoInterface {
    private  List<Product> productList;

    @Override
    public Product getProduct (int index) {
        return productList.get(index);
    }

    public void addProduct (Product product) {
        productList.add(product);
    }

    public void updateProduct (Product product) {
        int index = productList.indexOf(product);
        productList.set(index, product);
    }

    public void deleteProduct (Product product) {
        productList.remove(product);
    }

    @Override
    public List<Product> getProductList() {
        return Collections.unmodifiableList(productList);
    }

    @PostConstruct
    public void init() {
        productList = new ArrayList<>();
        productList.add(new Product(1, "яблоко", 59.9f));
        productList.add(new Product(2, "огурец", 229.9f));
        productList.add(new Product(3, "банан", 159.9f));
        productList.add(new Product(4, "сахар-песок", 59.9f));
        productList.add(new Product(5, "горох колотый", 89.9f));
    }
}
