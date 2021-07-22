package ru.geekbrains.app.homework9.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.app.homework9.model.Dto.ProductDto;
import ru.geekbrains.app.homework9.model.Entity.Cart;
import ru.geekbrains.app.homework9.model.Entity.Product;
import ru.geekbrains.app.homework9.repositories.ProductsRepoInterface;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CartService {

    private final ProductsRepoInterface productsRepoInterface;
    private HashMap<Product, Float> cart;

    public void addToCart(Long id, Float count) {
        System.out.println("добавление в корзину");
        Product product = productsRepoInterface.findProductById(id);
        if (cart.containsKey(product))
        {
            cart.replace(product, cart.get(product) + count);
        } else {
            cart.put(product, count);
        }
    }

    public void removeProductFromCart(Product product) {
        if (cart.containsKey(product)) {
           cart.remove(product);
        }
    }

    public Map<Product, Float> getCart() {
        return cart;
    }

    public void deleteById(Long id) {
        Product product = productsRepoInterface.findProductById(id);
        cart.remove(product);
    }
}
