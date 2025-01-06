package com.example.ecommerce.controller;

import com.example.ecommerce.entity.AppUser;
import com.example.ecommerce.entity.Cart;
import com.example.ecommerce.entity.CartItem;
import com.example.ecommerce.service.CartService;
import com.example.ecommerce.repository.AppUserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private AppUserRepository appUserRepository;

    @GetMapping
    public String viewCart(Model model, HttpSession session) {  
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/login";
        }

        AppUser appUser = appUserRepository.findById(userId).orElse(null);
        if (appUser == null) {
            return "redirect:/login";
        }

        Cart cart = cartService.getCartByUserId(appUser.getId());
        if (cart == null) {
            model.addAttribute("message", "Your cart is empty!");
            model.addAttribute("cartItems", List.of());
            model.addAttribute("totalPrice", BigDecimal.ZERO);
            return "cart";
        }

        List<CartItem> cartItems = cart.getCartItems();
        BigDecimal totalPrice = cartItems.stream()
                .map(cartItem -> cartItem.getProduct().getPrice().multiply(new BigDecimal(cartItem.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        model.addAttribute("cartItems", cartItems);
        model.addAttribute("totalPrice", totalPrice);
        return "cart";
    }

    @PostMapping("/add")
    public ResponseEntity<String> addToCart(@RequestParam("productId") Long productId,
                                            @RequestParam("quantity") int quantity,
                                            HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return ResponseEntity.status(401).body("User not authenticated");
        }

        cartService.addToCart(userId, productId, quantity);
        return ResponseEntity.ok("Product added to cart!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCartItem(@PathVariable Long id) {
        cartService.deleteCartItem(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Void> updateCartItem(@PathVariable Long id, @RequestBody Map<String, Integer> payload) {
        int quantity = payload.get("quantity");
        cartService.updateCartItemQuantity(id, quantity);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<Void> deleteAllCartItems(HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return ResponseEntity.status(401).build();
        }

        cartService.deleteAllCartItems(userId);
        return ResponseEntity.ok().build();
    }

}