package ru.geekbrains.spring.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private ProductsRepoInterface productsRepoInterface;

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
        for (Product product: productsRepoInterface.getProductList()) {
            avg += product.getCost();
        }
        return avg /= getCountProducts();
    }
}
