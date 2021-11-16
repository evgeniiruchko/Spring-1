package ru.geekbrains.app.homework9.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.app.homework9.exceptions.ResourceNotFoundException;
import ru.geekbrains.app.homework9.model.Entity.Product;
import ru.geekbrains.app.homework9.model.Dto.ProductDto;
import ru.geekbrains.app.homework9.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping ("/{id}")
    public ProductDto getProductById(@PathVariable Long id) {
        return productService.getProductById(id).orElseThrow(() -> new ResourceNotFoundException("Товар с id = " + id + " Не найден"));
    }

    @GetMapping ("/title")
    public List<Product> getProductByTitle(@RequestParam String title) {
        return productService.getProductByTitle(title);
    }

    @GetMapping
    public List<ProductDto> getProductBeforeMaxPrice(@RequestParam(name = "min_price", defaultValue = "0") Float priceMin,
                                                  @RequestParam(name = "max_price", required = false) Float priceMax)
    {
        if (priceMax == null) {
            priceMax = Float.MAX_VALUE;
        }
        return productService.getProductBetweenPrices(priceMin, priceMax);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Long id) {
        productService.deleteById(id);
    }


    @PostMapping
    public Product addProduct(@RequestBody Product product) {
            return productService.saveProduct(product);
    }
}
