package ru.geekbrains.app.homework9.services;

import org.springframework.stereotype.Service;
import ru.geekbrains.app.homework9.model.Entity.Product;
import ru.geekbrains.app.homework9.model.Dto.ProductDto;

@Service
public class MappingUtils {

    public ProductDto mapToProductDto(Product product){
        ProductDto dto = new ProductDto(product);
        return dto;
    }

    public Product mapToProductEntity(ProductDto dto){
        Product product = new Product();
        product.setId(dto.getId());
        product.setTitle(dto.getTitle());
        product.setPrice(dto.getPrice());
        return product;
    }
}
