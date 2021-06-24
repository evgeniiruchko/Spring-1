package ru.geekbrains.mvc.repositories;

import ru.geekbrains.mvc.model.Product;

import java.util.List;

public interface ProductsRepoInterface {
    List<Product> getProductList();
    public Product getProduct(int index);
}
