package ru.geekbrains.app.homework9.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.app.homework9.model.Entity.Product;
import ru.geekbrains.app.homework9.model.Dto.ProductDto;
import ru.geekbrains.app.homework9.repositories.ProductsRepoInterface;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductsRepoInterface productsRepoInterface;

    private final MappingUtils mappingUtils;

    public int getCountProducts() {
        return (int) productsRepoInterface.count();
    }

//    public List<Product> getAllProducts() {
//        return (List<Product>) productsRepoInterface.findAll();
//    }

//    public List<ProductDto> getAllSaleProducts() {
//        return productsRepoInterface.findAllBySaleIsTrueAndOldPriceNotNull().stream().map(ProductDto::new);
//    }

    public Optional<ProductDto> getProductById(Long id) {
        return productsRepoInterface.findById(id).map(ProductDto::new);
    }

    public List<Product> getProductByTitle(String title) {
        return productsRepoInterface.findProductByTitleContainingIgnoreCase(title);
    }

//    public List<Product> getProductBeforeMaxPrice(Float price) {
//        return productsRepoInterface.findAllByPriceLessThanEqual(price);
//    }
//
//    public List<Product> getProductAfterMinPrice(float price) {
//        return productsRepoInterface.findAllByPriceGreaterThanEqual(price);
//    }

    //получаем массив ProductDto в диапозоне цен
    public List<ProductDto> getProductBetweenPrices(float priceMin, float priceMax) {
        return productsRepoInterface.findAllByPriceBetween(priceMin, priceMax).stream()
                .map(ProductDto::new)
                .collect(Collectors.toList());
    }
//    public List<Product> getProductBetweenPrices(float priceMin, float priceMax) {
//        return productsRepoInterface.findAllByPriceBetween(priceMin, priceMax);
//    }

    public void deleteById (Long id) {
        productsRepoInterface.deleteById(id);
    }

    public Product saveProduct (Product product) {
        return productsRepoInterface.save(product);
    }

}
