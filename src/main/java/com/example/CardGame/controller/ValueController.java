package com.example.CardGame.controller;

import com.example.CardGame.dto.User;
import com.example.CardGame.dto.Value;
import com.example.CardGame.service.ValueUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "https://react-front-ngs2.onrender.com")
@RestController
@RequiredArgsConstructor
public class ValueController {

    @Autowired
    private ValueUseCase valueUseCase;

    @GetMapping("/value/{id}")
    public Optional<Value> doGetValue(@PathVariable String id){
        return valueUseCase.getValue(id);
    }
}


