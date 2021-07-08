package ru.geekbrains.app.homework7.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.app.homework7.model.Product;
import ru.geekbrains.app.homework7.repositories.ProductsRepoInterface;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {

    private ProductsRepoInterface productsRepoInterface;

    public int getCountProducts() {
        return (int) productsRepoInterface.count();
    }

    public List<Product> getAllProducts() {
        return (List<Product>) productsRepoInterface.findAll();
    }

    public Product getProductById(Long id) {
        return productsRepoInterface.findById(id).get();
    }

    public List<Product> getProductByTitle(String title) {
        return productsRepoInterface.findProductByTitleContainingIgnoreCase(title);
    }

    public List<Product> getProductBeforeMaxPrice(float price) {
        return productsRepoInterface.findAllByPriceLessThanEqual(price);
    }

    public List<Product> getProductAfterMinPrice(float price) {
        return productsRepoInterface.findAllByPriceGreaterThanEqual(price);
    }

    public List<Product> getProductBetweenPrices(float priceMin, float priceMax) {
        return productsRepoInterface.findAllByPriceGreaterThanEqualAndPriceLessThanEqual(priceMin, priceMax);
    }

    public void deleteById (Long id) {
        productsRepoInterface.deleteById(id);
    }

    public Product saveProduct (Product product) {
        return productsRepoInterface.save(product);
    }
}
