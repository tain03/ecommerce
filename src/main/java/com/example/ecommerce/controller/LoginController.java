package com.example.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";  // Trả về view "login.html" hoặc "login.jsp" tuỳ thuộc vào cấu hình của bạn
    }
}

