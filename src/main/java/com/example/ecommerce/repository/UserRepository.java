package com.example.ecommerce.repository;

import com.example.ecommerce.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByUsernameAndPassword(String username, String password);

    AppUser findByUsername(String username);
}