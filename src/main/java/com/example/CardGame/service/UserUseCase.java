package com.example.CardGame.service;

import com.example.CardGame.database.UserRepository;
import com.example.CardGame.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserUseCase {

    private final UserRepository userRepository;

    @Autowired
    public UserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String insertPoint(User user) {
        int pontuacao = userRepository.findByEmail(user.getEmail()).get().getPoint();
        user.setPoint(pontuacao + 10);
        userRepository.save(user);
        return "Sua pontuação " + user.getPoint();
    }

    public boolean findLogin(User user ){
        return userRepository.findByEmail(user.getEmail()).isEmpty();
    }

    public boolean verify(User user){
        if (findLogin(user)){
            user.setPoint(0);
            userRepository.save(user);
            return false;
        }else{
            userRepository.insert(user);
            return true;
        }
    }

    public int getScore(User user){
        return userRepository.findByEmail(user.getEmail()).get().getPoint();
    }
}