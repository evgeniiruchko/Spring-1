package ru.geekbrains.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.geekbrains.mvc.services.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public String getAllProducts(Model model) {
        model.addAttribute("frontProducts", productService.getAllProducts());
        return "allproducts";
    }

//    @GetMapping("/remove/{id}")
//    public String deleteBoxById(@PathVariable Long id) {
//        boxService.deleteById(id);
//        return "redirect:/boxes/all";
//    }
//
//    @PostMapping("/add")
////    public String addNewBox(@RequestParam Long id, @RequestParam String color, @RequestParam int size) {
//    public String addNewBox(@ModelAttribute Box box) {
//        boxService.save(box);
//        return "redirect:/boxes/all";
//    }
//
//    @PostMapping("/json/add")
//    @ResponseStatus(HttpStatus.CREATED)
//    public void addNewJsonBox(@RequestBody Box box) {
//        boxService.save(box);
//    }
}
