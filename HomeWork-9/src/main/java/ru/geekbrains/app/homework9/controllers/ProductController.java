package ru.geekbrains.app.homework9.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.app.homework9.exceptions.ResourceNotFoundException;
import ru.geekbrains.app.homework9.model.Entity.Cart;
import ru.geekbrains.app.homework9.model.Entity.Product;
import ru.geekbrains.app.homework9.model.Dto.ProductDto;
import ru.geekbrains.app.homework9.services.ProductService;
import ru.geekbrains.app.homework9.utils.MapperUtil;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private ProductService productService;
    private ModelMapper modelMapper;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

//    @GetMapping("/sale")
//    public List<ProductDto> getAllSaleProducts(Model model) {
//        return productService.getAllSaleProducts();
//    }

    @GetMapping ("/{id}")
    public ProductDto getProductById(@PathVariable Long id) {
        return productService.getProductById(id).orElseThrow(() -> new ResourceNotFoundException("Товар с id = " + id + " Не найден"));
    }

    @GetMapping ("/title")
    public List<Product> getProductByTitle(@RequestParam String title) {
        return productService.getProductByTitle(title);
    }

//    @GetMapping ("/minPrice")
//    public List<Product> getProductAfterMinPrice(@RequestParam Float price) {
//        return productService.getProductAfterMinPrice(price);
//    }
//
//    @GetMapping ("/maxPrice")
//    public List<Product> getProductBeforeMaxPrice(@RequestParam Float price) {
//        return productService.getProductBeforeMaxPrice(price);
//    }

    @GetMapping
    public List<ProductDto> getProductBeforeMaxPrice(@RequestParam(name = "min_price", defaultValue = "0") Float priceMin,
                                                  @RequestParam(name = "max_price", required = false) Float priceMax)
    {
        if (priceMax == null) {
            priceMax = Float.MAX_VALUE;
        }
        return productService.getProductBetweenPrices(priceMin, priceMax);
//так не работает из-за convertList
//        List<Product> products = productService.getProductBetweenPrices(priceMin, priceMax);
//        return MapperUtil.convertList(products, this::convertToPostDto);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Long id) {
        productService.deleteById(id);
    }


    @PostMapping
    public Product addProduct(@RequestBody Product product) {
            return productService.saveProduct(product);
    }

    private ProductDto convertToPostDto(Product product) {
        return modelMapper.map(product, ProductDto.class);
    }
}
