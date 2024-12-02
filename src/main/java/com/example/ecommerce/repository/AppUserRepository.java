package com.example.ecommerce.repository;

import com.example.ecommerce.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByUsername(String username);  // Tìm người dùng theo username
}
