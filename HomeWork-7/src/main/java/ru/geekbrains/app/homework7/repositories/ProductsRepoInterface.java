package ru.geekbrains.app.homework7.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.app.homework7.model.Product;

import java.util.List;
import java.util.Optional;


@Repository
public interface ProductsRepoInterface extends JpaRepository<Product, Long> {

    List<Product> findProductByTitleContainingIgnoreCase(String title);

    List<Product> findAllByPriceGreaterThanEqual(float price);
    List<Product> findAllByPriceLessThanEqual(float price);
    List<Product> findAllByPriceGreaterThanEqualAndPriceLessThanEqual(float priceMin, float priceMax);
}
