package com.example.ecommerce.controller;

import com.example.ecommerce.entity.AppUser;
import com.example.ecommerce.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";  // Return the view "login.html" or "login.jsp" depending on your configuration
    }

    @PostMapping("/login")
    public ModelAndView login(@RequestParam("username") String username,
                              @RequestParam("password") String password,
                              HttpSession session) {
        AppUser user = userService.authenticate(username, password);
        if (user != null) {
            session.setAttribute("userId", user.getId());
            if (user.getId() == 1) {
                return new ModelAndView("redirect:/admin/products");
            } else {
                return new ModelAndView("redirect:/");
            }
        } else {
            return new ModelAndView("login").addObject("error", "Invalid username or password");
        }
    }
}