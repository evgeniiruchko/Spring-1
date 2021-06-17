package ru.geekbrains.spring.context;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        ProductService productService = context.getBean("productService", ProductService.class);
        System.out.printf("Количество товаров: " + productService.getCountProducts() + System.lineSeparator());
        System.out.printf("Средняя цена: " + productService.getAverageCost() + System.lineSeparator());
        System.out.printf("Первый товар: " + productService.productRepo.getProduct(0).toString()  + System.lineSeparator());
        System.out.printf("Добавляем арбуз..." + System.lineSeparator());
        productService.productRepo.addProduct(new Product(6, "Арбуз", 99.9f));
        System.out.println("теперь список такой: " + productService.productRepo.getProductList());

        context.close();
    }
}
