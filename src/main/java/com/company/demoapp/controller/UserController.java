package com.company.demoapp.controller;

import com.company.demoapp.model.Card;
import com.company.demoapp.model.CardTransaction;
import com.company.demoapp.model.User;
import com.company.demoapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user-info/{userId}")
    public ResponseEntity<User> getUserInfo(@PathVariable Long userId) {
        User user = userService.getUserInfo(userId);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @GetMapping("/user-info")
    public ResponseEntity<List<User>> getAllUserInfo() {
        return ResponseEntity.ok(userService.getAllUserInfo());
    }
}
