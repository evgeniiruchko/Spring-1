package ru.geekbrains.homework4.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.homework4.model.Product;
import ru.geekbrains.homework4.repositories.ProductRepo;
import ru.geekbrains.homework4.repositories.ProductsRepoInterface;
import ru.geekbrains.homework4.exceptions.*;

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

//    private Product getProductByIndex(long id) {
////        List<Product> list= getAllProducts();
////        for (Product product : list) {
////            if (product.getId() == id) {
////                return product;
////            }
////        }
//        getAllProducts().stream()
//                .filter(p -> p.getId() == id)
//                .findFirst();
//        return null;
//    }

    public void deleteById (long id) {
        //productRepo.deleteProduct(productRepo.getProductByIndex(id));
        productRepo.deleteById(id);
    }

    public void saveProduct (Product product) {
        if (productRepo.getProductByIndex(product.getId()) != null)
            productRepo.addProduct(product);
        else
            throw new ResourceExistsException("Товар с таким ID уже сужествует");
    }
}
