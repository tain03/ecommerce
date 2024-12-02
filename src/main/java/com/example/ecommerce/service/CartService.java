package com.example.ecommerce.service;

import com.example.ecommerce.entity.Cart;
import com.example.ecommerce.entity.CartItem;
import com.example.ecommerce.entity.Product;
import com.example.ecommerce.repository.CartRepository;
import com.example.ecommerce.repository.CartItemRepository;
import com.example.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CartItemRepository cartItemRepository;  // Inject CartItemRepository

    // Lấy giỏ hàng của người dùng theo username
    public Cart getCartByUserId(String username) {
        return cartRepository.findByUserUsername(username)
                .orElseThrow(() -> new RuntimeException("Cart not found"));
    }

    // Thêm sản phẩm vào giỏ hàng
    public void addToCart(String username, Long productId, int quantity) {
        // Lấy giỏ hàng của người dùng
        Cart cart = cartRepository.findByUserUsername(username)
                .orElseThrow(() -> new RuntimeException("Cart not found"));

        // Lấy thông tin sản phẩm
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        // Kiểm tra xem sản phẩm đã tồn tại trong giỏ hàng chưa
        Optional<CartItem> existingCartItem = cart.getCartItems().stream()
                .filter(cartItem -> cartItem.getProduct().getId().equals(productId))
                .findFirst();

        if (existingCartItem.isPresent()) {
            // Nếu đã tồn tại, cập nhật số lượng
            CartItem cartItem = existingCartItem.get();
            cartItem.setQuantity(cartItem.getQuantity() + quantity);
        } else {
            // Nếu chưa tồn tại, tạo mới một CartItem và thêm vào giỏ hàng
            CartItem cartItem = new CartItem();
            cartItem.setCart(cart);
            cartItem.setProduct(product);
            cartItem.setQuantity(quantity);
            cart.getCartItems().add(cartItem);
        }

        // Lưu giỏ hàng
        cartRepository.save(cart);
    }

    // Xóa CartItem
    public void deleteCartItem(Long id) {
        cartItemRepository.deleteById(id);  // Xóa CartItem theo ID
    }

    // Cập nhật số lượng CartItem
    public void updateCartItemQuantity(Long id, int quantity) {
        CartItem cartItem = cartItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cart item not found"));
        cartItem.setQuantity(quantity);  // Cập nhật số lượng
        cartItemRepository.save(cartItem);  // Lưu CartItem sau khi cập nhật
    }
}
