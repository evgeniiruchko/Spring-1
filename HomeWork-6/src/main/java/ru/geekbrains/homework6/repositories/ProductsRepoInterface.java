package ru.geekbrains.homework6.repositories;

import ru.geekbrains.homework6.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductsRepoInterface {
    List<Product> getProductList();
    public Optional<Product> getProductByIndex(long index);
}
