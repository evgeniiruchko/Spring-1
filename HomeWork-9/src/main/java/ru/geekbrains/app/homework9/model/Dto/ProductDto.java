package ru.geekbrains.app.homework9.model.Dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.app.homework9.model.Entity.Product;

@Data
@NoArgsConstructor
public class ProductDto {
    private Long id;
    private String title;
    private Float price;
    private String category;

    public ProductDto(Product product) {
        this.id = product.getId();
        this.title = product.getTitle();
        this.price = product.getPrice();
        this.category = product.getCategory().getTitle();
    }
}
