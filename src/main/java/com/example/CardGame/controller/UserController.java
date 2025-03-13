package com.example.CardGame.controller;

import com.example.CardGame.database.UserRepository;
import com.example.CardGame.dto.User;
import com.example.CardGame.service.UserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "https://react-front-ngs2.onrender.com")
@RestController
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserUseCase userUseCase;

    @PostMapping("/signup/{id}")
    public boolean doPostUser(@PathVariable String id, @RequestBody User user){
        return userUseCase.verify(id, user);
    }

    @PostMapping("/login/{id}")
    public boolean doLogin(@PathVariable String id, @RequestBody User user){
        return userUseCase.login(id, user);
    }

    @PostMapping("/point")
    public String updatePoint(@RequestBody User user){
        return userUseCase.insertPoint(user);
    }

    @GetMapping("/user/{id}")
    public Optional<User> doGetUser(@PathVariable String id){
        return userUseCase.getUser(id);
    }
}
