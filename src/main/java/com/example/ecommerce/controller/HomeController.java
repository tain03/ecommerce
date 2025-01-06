package com.example.ecommerce.controller;

import com.example.ecommerce.entity.Comment;
import com.example.ecommerce.entity.Product;
import com.example.ecommerce.entity.AppUser;
import com.example.ecommerce.service.ProductService;
import com.example.ecommerce.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ProductService productService;

    @Autowired
    private AppUserService appUserService;

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
        return "index";
    }

    @GetMapping("/category/{categoryId}/{productId}")
    public String getProductDetails(@PathVariable Long productId, Model model) {
        Product product = productService.getProductById(productId);
        List<Comment> comments = productService.getCommentsByProductId(productId);
        model.addAttribute("title", "ShopEase - Product Details");
        model.addAttribute("product", product);
        model.addAttribute("comments", comments);
        return "product-details";
    }


}