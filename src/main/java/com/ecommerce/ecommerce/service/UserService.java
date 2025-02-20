package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.Repository.UserRepository;
import com.ecommerce.ecommerce.dominio.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;
    private final PasswordEncoder encoder;

    @Autowired
    public UserService(UserRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    public User createUser(User user) {
        if (user.getUsername() == null || user.getUsername().isBlank()) {
            throw new IllegalArgumentException("Username não pode ser nulo ou vazio");
        }
        if (user.getPassword() == null || user.getPassword().isBlank()) {
            throw new IllegalArgumentException("Password não pode ser nulo ou vazio");
        }

        String encodedPass = encoder.encode(user.getPassword());
        user.setPassword(encodedPass);

        return repository.save(user);
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }
}
