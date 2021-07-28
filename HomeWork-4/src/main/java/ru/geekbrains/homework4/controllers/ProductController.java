package ru.geekbrains.homework4.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.homework4.model.Product;
import ru.geekbrains.homework4.services.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public String getAllProducts(Model model) {
        model.addAttribute("frontProducts", productService.getAllProducts());
        return "allproducts";
    }

    @GetMapping("/remove/{id}")
    public String deleteProductById(@PathVariable Long id) {
        productService.deleteById(id);
        return "redirect:/products/all";
    }

    @PostMapping("/add")
        public String addNewBox(@ModelAttribute Product product) {
        productService.saveProduct(product);
        return "redirect:/products/all";
    }

    @PostMapping("/json/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addNewJsonBox(@RequestBody Product product) {
        productService.saveProduct(product);
    }
}
