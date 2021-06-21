package ru.geekbrains.spring.context;

import java.util.List;

public interface ProductsRepoInterface {
    List<Product> getProductList();
    public Product getProduct(int index);
}
