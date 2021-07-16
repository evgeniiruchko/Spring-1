package ru.geekbrains.app.homework9.model.Dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.app.homework9.model.Entity.Category;

@Data
@NoArgsConstructor
public class CategoryDto {
    private Long id;
    private String title;

    public CategoryDto (Category category) {
        this.id = category.getId();
        this.title = category.getTitle();
    }
}
