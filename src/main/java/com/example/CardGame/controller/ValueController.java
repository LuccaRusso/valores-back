package com.example.CardGame.controller;

import com.example.CardGame.dto.Value;
import com.example.CardGame.service.ValueUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "https://site-ggqf.onrender.com")
@RestController
@RequiredArgsConstructor
public class ValueController {

    @Autowired
    private ValueUseCase valueUseCase;

    @PostMapping("/insertValue")
    public String doPostInsertValue(@RequestBody Value value) {
        return valueUseCase.insertValue(value);
    }

    @GetMapping("/compareTo")
    public boolean doGetValidation(@RequestBody Value value){
        return valueUseCase.compareTo(value);
    }
}
