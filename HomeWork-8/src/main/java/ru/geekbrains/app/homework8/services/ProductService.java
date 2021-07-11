package ru.geekbrains.app.homework8.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.app.homework8.model.Product;
import ru.geekbrains.app.homework8.repositories.ProductsRepoInterface;

import java.util.List;

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

    public List<Product> getAllSaleProducts() {
        return (List<Product>) productsRepoInterface.findAllBySaleIsTrueAndOldPriceNotNull();
    }

    public Product getProductById(Long id) {
        return productsRepoInterface.findById(id).get();
    }

    public List<Product> getProductByTitle(String title) {
        return productsRepoInterface.findProductByTitleContainingIgnoreCase(title);
    }

    public List<Product> getProductBeforeMaxPrice(Float price) {
        return productsRepoInterface.findAllByPriceLessThanEqual(price);
    }

    public List<Product> getProductAfterMinPrice(float price) {
        return productsRepoInterface.findAllByPriceGreaterThanEqual(price);
    }

    public List<Product> getProductBetweenPrices(float priceMin, float priceMax) {
        return productsRepoInterface.findAllByPriceBetween(priceMin, priceMax);
    }

    public void deleteById (Long id) {
        productsRepoInterface.deleteById(id);
    }

    public Product saveProduct (Product product) {
        return productsRepoInterface.save(product);
    }
}
