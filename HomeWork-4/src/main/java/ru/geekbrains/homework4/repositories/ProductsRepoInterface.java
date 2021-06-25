package ru.geekbrains.homework4.repositories;

import ru.geekbrains.homework4.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductsRepoInterface {
    List<Product> getProductList();
    public Optional<Product> getProductByIndex(long index);
}
