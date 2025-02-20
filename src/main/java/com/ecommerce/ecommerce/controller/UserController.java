package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.dominio.User;
import com.ecommerce.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User createdUser = service.createUser(user);
        return ResponseEntity.ok(createdUser);
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> users = service.getAllUsers();
        return ResponseEntity.ok(users);
    }


}
