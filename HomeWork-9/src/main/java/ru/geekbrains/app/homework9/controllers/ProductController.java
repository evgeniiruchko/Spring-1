package ru.geekbrains.app.homework9.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.app.homework9.model.Product;
import ru.geekbrains.app.homework9.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

//    @GetMapping
//    public List<Product> getAllProducts(Model model) {
//        return productService.getAllProducts();
//    }

    @GetMapping("/sale")
    public List<Product> getAllSaleProducts(Model model) {
        return productService.getAllSaleProducts();
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
    public List<Product> getProductAfterMinPrice(@RequestParam Float price) {
        return productService.getProductAfterMinPrice(price);
    }

    @GetMapping ("/maxPrice")
    public List<Product> getProductBeforeMaxPrice(@RequestParam Float price) {
        return productService.getProductBeforeMaxPrice(price);
    }

    @GetMapping
    public List<Product> getProductBeforeMaxPrice(@RequestParam(name = "min_price", defaultValue = "0") Float priceMin,
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
