package com.example.ecommerce.controller;

import com.example.ecommerce.entity.AppUser;
import com.example.ecommerce.entity.Cart;
import com.example.ecommerce.entity.CartItem;
import com.example.ecommerce.service.CartService;
import com.example.ecommerce.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Controller
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private AppUserRepository appUserRepository;

    @GetMapping("/cart")
    public String viewCart(Model model) {
        // Đặt username mặc định là "admin"
        String username = "admin";

        // Tìm người dùng trong database bằng username
        AppUser appUser = appUserRepository.findByUsername(username);
        if (appUser == null) {
            // Nếu không tìm thấy người dùng "admin", chuyển hướng về trang đăng nhập
            return "redirect:/login";
        }

        // Lấy giỏ hàng của người dùng "admin"
        Cart cart = cartService.getCartByUserId(username);
        if (cart == null) {
            // Nếu không tìm thấy giỏ hàng của "admin", hiển thị thông báo giỏ hàng trống
            model.addAttribute("message", "Giỏ hàng trống!");
            model.addAttribute("cartItems", List.of());
            model.addAttribute("totalPrice", 0);
            return "cart";
        }

        List<CartItem> cartItems = cart.getCartItems();

        // Tính tổng giá trị giỏ hàng
        double totalPrice = cartItems.stream()
                .mapToDouble(cartItem ->
                        cartItem.getProduct().getPrice()
                                .multiply(new BigDecimal(cartItem.getQuantity())) // Chuyển từ int sang BigDecimal
                                .doubleValue()) // Chuyển kết quả thành double
                .sum();

        // Thêm giỏ hàng và tổng giá trị vào model
        model.addAttribute("cartItems", cartItems);
        model.addAttribute("totalPrice", totalPrice);
        return "cart";  // Trả về view cart.html
    }

    @PostMapping("/cart/add")
    public ResponseEntity<String> addToCart(@RequestParam("productId") Long productId,
                                            @RequestParam("quantity") int quantity) {
        // Đặt username mặc định là "admin"
        String username = "admin";

        // Gọi service để thêm sản phẩm vào giỏ hàng
        cartService.addToCart(username, productId, quantity);

        // Trả về thông báo thành công
        return ResponseEntity.ok("Sản phẩm đã được thêm vào giỏ hàng!");
    }

    @DeleteMapping("/cart/delete/{id}")
    public ResponseEntity<Void> deleteCartItem(@PathVariable Long id) {
        // Xóa sản phẩm trong giỏ hàng
        cartService.deleteCartItem(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/cart/update/{id}")
    public ResponseEntity<Void> updateCartItem(@PathVariable Long id, @RequestBody Map<String, Integer> payload) {
        // Cập nhật số lượng sản phẩm trong giỏ hàng
        int quantity = payload.get("quantity");
        cartService.updateCartItemQuantity(id, quantity);
        return ResponseEntity.ok().build();
    }
}
