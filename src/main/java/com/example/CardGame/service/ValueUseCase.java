package com.example.CardGame.service;

import com.example.CardGame.database.ValueRepository;
import com.example.CardGame.dto.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ValueUseCase {

        private final ValueRepository valueRepository;

        @Autowired
        public ValueUseCase(ValueRepository valueRepository) {
            this.valueRepository = valueRepository;
        }

        public Optional<Value> getValue(String id){
            return valueRepository.findById(id);
        }
}
