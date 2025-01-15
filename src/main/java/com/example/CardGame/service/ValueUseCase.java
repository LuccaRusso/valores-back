package com.example.CardGame.service;

import com.example.CardGame.database.ValueRepository;
import com.example.CardGame.dto.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValueUseCase {

        private final ValueRepository valueRepository;

        @Autowired
        public ValueUseCase(ValueRepository valueRepository) {
            this.valueRepository = valueRepository;
        }

        public String insertValue(Value value){
            try{
                valueRepository.insert(value);
                return "Valor inserido com sucesso!";
            }catch (Exception e){
                return "Valor não inserido no banco!";
            }
        }

        public boolean compareTo(Value value){
            return valueRepository.findByAll(value.getValue(),value.getQuestion()).isPresent();
        }
}
