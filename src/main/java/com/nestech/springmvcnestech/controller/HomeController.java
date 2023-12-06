package com.nestech.springmvcnestech.controller;

import com.nestech.springmvcnestech.model.Product;
import com.nestech.springmvcnestech.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class HomeController {

    @Autowired
    ProductService productService;

    @GetMapping("/product/get")
    public String home(Model model) {
        model.addAttribute("listProduct", productService.getAll());
        return "home";
    }

    @GetMapping("/product/add")
    public String redirectProduct() {
        return "add-product";
    }

    @GetMapping("/product/delete")
    public RedirectView deleteProduct(@RequestParam("id") int id) {
        productService.delete(id);
        return new RedirectView("/product/get");
    }

    @PostMapping("/product/add")
    public RedirectView addProduct(@ModelAttribute Product product) {
        productService.addProduct(product);
        return new RedirectView("/product/get");
    }

    @GetMapping("/product/update")
    public String redirectProductUpdate(@RequestParam("id") int id, Model model) {
        Product product = productService.getById(id);
        model.addAttribute("productUpdate", product);
        return "update-product";
    }

    @PostMapping("/product/update/{id}")
    public RedirectView updateProduct(@PathVariable("id") int id,
                                      Product product) {
        productService.update(id, product.getName(), product.getNumber());
        return new RedirectView("/product/get");
    }
}
