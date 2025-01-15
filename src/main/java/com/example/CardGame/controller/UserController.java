package com.example.CardGame.controller;

import com.example.CardGame.database.UserRepository;
import com.example.CardGame.dto.User;
import com.example.CardGame.service.UserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "https://site-ggqf.onrender.com")
@RestController
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserUseCase userUseCase;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/signup")
    public Boolean doPostSingUp(@RequestBody User user) {
        return userUseCase.verify(user);
    }

    @GetMapping("/login")
    public Boolean doPostLogin(@RequestBody User user){
        return userUseCase.findLogin(user);
    }

    @PutMapping("/doPoint")
    public String doPutPoint(@RequestBody User user){
        return userUseCase.insertPoint(user);
    }

    @GetMapping("/score")
    public int doGetScore(@RequestBody User user){
        return userUseCase.getScore(user);
    }
}
