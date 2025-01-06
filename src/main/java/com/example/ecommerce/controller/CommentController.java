package com.example.ecommerce.controller;

import com.example.ecommerce.entity.Comment;
import com.example.ecommerce.entity.Product;
import com.example.ecommerce.entity.AppUser;
import com.example.ecommerce.service.ProductService;
import com.example.ecommerce.service.AppUserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class CommentController {

    @Autowired
    private ProductService productService;

    @Autowired
    private AppUserService appUserService;

    @PostMapping("/{productId}/comment")
    public String addComment(@PathVariable Long productId, @RequestParam String content, @RequestParam int rating, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/login";
        }

        Product product = productService.getProductById(productId);
        AppUser user = appUserService.getUserById(userId);
        Comment comment = new Comment();
        comment.setContent(content);
        comment.setRating(rating);
        comment.setProduct(product);
        comment.setUser(user);
        productService.addComment(comment);
        return "redirect:/category/" + product.getCategory().getId() + "/" + productId;
    }
}