package ru.geekbrains.homework4.repositories;

import org.springframework.stereotype.Repository;
import ru.geekbrains.homework4.model.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepo implements ProductsRepoInterface {
    private  List<Product> productList;

    @Override
    public Optional<Product> getProductByIndex(long index) {
        //return productList.get(index);
        return productList.stream().filter(p -> p.getId() == index).findFirst();
    }

    public void addProduct (Product product) {
        productList.add(product);
    }

    public void updateProduct (Product product) {
        int index = productList.indexOf(product);
        productList.set(index, product);
    }

    public void deleteProduct (Optional<Product> product) {
        productList.remove(product);
    }

    public void deleteById (float id) {
        productList.removeIf(p -> p.getId() == id);
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
        System.out.println("инициализация прошла успешно");
    }
}
