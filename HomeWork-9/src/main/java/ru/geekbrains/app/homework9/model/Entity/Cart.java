package ru.geekbrains.app.homework9.model.Entity;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private static Map<Product, Float> cart;
    private static Cart instance;

    private Cart(){cart = new HashMap<>();}

    public static Cart getCart(){
        if(instance == null){
            instance = new Cart();
        }
        return instance;
    }
}
