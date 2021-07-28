package ru.geekbrains.homework4.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.homework4.model.Product;
import ru.geekbrains.homework4.repositories.ProductRepo;
import ru.geekbrains.homework4.repositories.ProductsRepoInterface;

import java.util.List;

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
        for (Product product : productsRepoInterface.getProductList()) {
            avg += product.getCost();
        }
        return avg /= getCountProducts();
    }

    public List<Product> getAllProducts() {
        return productRepo.getProductList();
    }

    public void deleteById (long id) {
        productRepo.deleteById(id);
    }

    public void saveProduct (Product product) {
        productRepo.getProductByIndex(product.getId()).ifPresent(p -> productRepo.addProduct(product));
    }
}
