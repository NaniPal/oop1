package com.example.demo.repositories;
import com.example.demo.models.User;

public interface UserRepository {
    User save(User user);
    User findByUsername(String username);
    User findByEmail(String email);
}
