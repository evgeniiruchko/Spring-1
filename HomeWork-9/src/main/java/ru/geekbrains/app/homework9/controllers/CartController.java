package ru.geekbrains.app.homework9.controllers;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.app.homework9.model.Dto.ProductDto;
import ru.geekbrains.app.homework9.model.Entity.Product;
import ru.geekbrains.app.homework9.services.CartService;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cart")
public class CartController {
    private final CartService cartService;

    @GetMapping
    public Map<Product, Float> getCart() {
        return cartService.getCart();
    }

    @PostMapping
    public void addToCart(@RequestBody Long id) {
        System.out.println("Дошли до выполнения запроса");
        cartService.addToCart(id, 1F);
    }

    @DeleteMapping("/{id}")
    public void deleteFromCart(@PathVariable Long id) {
        cartService.deleteById(id);
    }
}
