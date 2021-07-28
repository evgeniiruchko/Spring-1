package ru.geekbrains.mvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.mvc.model.Product;
import ru.geekbrains.mvc.repositories.ProductRepo;
import ru.geekbrains.mvc.repositories.ProductsRepoInterface;

import java.util.List;

@Service
public class ProductService {

    private final ProductsRepoInterface productsRepoInterface;

    @Autowired
    ProductRepo productRepo;

    public ProductService(ProductsRepoInterface productRepo) {
        this.productsRepoInterface = productRepo;
    }

    public int getCountProducts() {
        return productsRepoInterface.getProductList().size();
    }

    public float getAverageCost() {
        if (getCountProducts() == 0) {
            return 0;
        }
        float avg = 0;
        for (Product product : productsRepoInterface.getProductList()) {
            avg += product.getCost();
        }
        return avg /= getCountProducts();
    }

    public List<Product> getAllProducts() {
        return productRepo.getProductList();
    }
}
