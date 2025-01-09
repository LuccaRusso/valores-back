package com.example.CardGame.controller;

import com.example.CardGame.database.Connection;
import com.example.CardGame.dto.User;
import com.example.CardGame.service.CardGameService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequiredArgsConstructor
public class CardGameController {

    @Autowired
    private CardGameService cardGameService;

    @PostMapping("/cadastro")
    public Boolean doPost(@RequestBody User user) {
        return CardGameService.verify(user);
    }

    @PostMapping("/login")
    public Boolean doLogin(@RequestBody User user){
        return CardGameService.findLogin(user);
    }

    @PostMapping("/pontuar")
    public String doFilter(@RequestBody User user){
        CardGameService.insertPoint(user.getEmail());
        return "Sua pontuação " + user.getPoint();
    }

    @PostMapping("/pontos")
    public String pontos(@RequestBody User user){
        return Connection.find(user.getEmail()).toString();
    }
}
