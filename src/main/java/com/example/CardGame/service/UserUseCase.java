package com.example.CardGame.service;

import com.example.CardGame.database.UserRepository;
import com.example.CardGame.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserUseCase {

    private final UserRepository userRepository;

    @Autowired
    public UserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean verify(String id, User user){
        if (userRepository.findById(id).isPresent()){
            return false;
        }
        user.setId(id);
        userRepository.save(user);
        return true;
    }

    public String insertPoint(User user) {
        userRepository.save(user);
        return String.valueOf(user.getPoint());
    }

    public boolean login(String id, User user){
        return userRepository.findById(id).isPresent() && userRepository.findById(id).get().getPassword().equals(user.getPassword());
    }

    public Optional<User> getUser(String id){
        return userRepository.findById(id);
    }
}