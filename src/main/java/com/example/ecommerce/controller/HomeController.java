package com.example.ecommerce.controller;

import com.example.ecommerce.entity.Product;
import com.example.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ProductService productService;

    // Hiển thị tất cả sản phẩm trên trang chủ
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "ShopEase - Home");
        model.addAttribute("products", productService.getAllProducts());
        return "index";
    }

    // Hiển thị sản phẩm theo danh mục
    @GetMapping("/category/{categoryId}")
    public String getProductsByCategory(@PathVariable Long categoryId, Model model) {
        model.addAttribute("title", "ShopEase - Category");
        model.addAttribute("categoryId", categoryId);
        model.addAttribute("products", productService.getProductsByCategory(categoryId));
        return "index";  // Có thể sử dụng lại trang index để hiển thị sản phẩm theo danh mục
    }
}

