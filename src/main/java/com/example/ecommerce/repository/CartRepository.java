package com.example.ecommerce.repository;

import com.example.ecommerce.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {

    // Tìm giỏ hàng của người dùng theo tên đăng nhập
    Optional<Cart> findByUserId(Long userId);
}
