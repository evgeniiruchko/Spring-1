package ru.geekbrains.app.homework7.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.app.homework7.model.Product;
import ru.geekbrains.app.homework7.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts(Model model) {
        return productService.getAllProducts();
    }

    @GetMapping ("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @GetMapping ("/title")
    public List<Product> getProductByTitle(@RequestParam String title) {
        return productService.getProductByTitle(title);
    }

    @GetMapping ("/minPrice")
    public List<Product> getProductAfterMinPrice(@RequestParam float price) {
        return productService.getProductAfterMinPrice(price);
    }

    @GetMapping ("/maxPrice")
    public List<Product> getProductBeforeMaxPrice(@RequestParam float price) {
        return productService.getProductBeforeMaxPrice(price);
    }

    @GetMapping ("/price")
    public List<Product> getProductBeforeMaxPrice(@RequestParam float priceMin, @RequestParam float priceMax) {
        return productService.getProductBetweenPrices(priceMin, priceMax);
    }

    @GetMapping("/remove/{id}")
    public void deleteProductById(@PathVariable Long id) {
        productService.deleteById(id);
    }

    @PostMapping("/add")
        public Product addProduct(@RequestBody Product product) {
            return productService.saveProduct(product);
    }
}
