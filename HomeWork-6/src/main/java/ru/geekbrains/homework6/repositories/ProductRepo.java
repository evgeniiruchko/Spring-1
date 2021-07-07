package ru.geekbrains.homework6.repositories;

import org.springframework.stereotype.Repository;
import ru.geekbrains.homework6.model.Product;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepo implements ProductsRepoInterface {
    private  List<Product> productList;

    @Override
    public Optional<Product> getProductByIndex(long index) {
        //return productList.get(index);
        return productList.stream().filter(p -> p.getId() == index).findFirst();
    }

    public void addProduct (Product product) {
        productList.add(product);
    }

    public void updateProduct (Product product) {
        int index = productList.indexOf(product);
        productList.set(index, product);
    }

    public void deleteProduct (Optional<Product> product) {
        productList.remove(product);
    }

    public void deleteById (float id) {
        productList.removeIf(p -> p.getId() == id);
    }

    @Override
    public List<Product> getProductList() {
        return Collections.unmodifiableList(productList);
    }

}
