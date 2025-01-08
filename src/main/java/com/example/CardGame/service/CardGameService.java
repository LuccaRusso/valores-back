package com.example.CardGame.service;

import com.example.CardGame.database.Connection;
import com.example.CardGame.dto.User;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.conversions.Bson;
import org.springframework.stereotype.Service;

@Service
public class CardGameService {

    public static void insertPoint(String email) {
        int pontuacao = Integer.parseInt(Connection.find(email).get("point").toString());
        Bson filter = Filters.eq("_id", email);
        if (pontuacao == 0){
            Bson update = Updates.set("point", 10);
            Connection.save(filter, update);
        }
        else if (pontuacao == 10){
            Bson update = Updates.set("point", 20);
            Connection.save(filter, update);
        }
        else if (pontuacao == 20){
            Bson update = Updates.set("point", 30);
            Connection.save(filter, update);
        }
        else if (pontuacao == 30){
            Bson update = Updates.set("point", 40);
            Connection.save(filter, update);
        }
        else if (pontuacao == 40){
            Bson update = Updates.set("point", 50);
            Connection.save(filter, update);
        }
        else if (pontuacao == 50){
            Bson update = Updates.set("point", 60);
            Connection.save(filter, update);
        }
        else if (pontuacao == 60){
            Bson update = Updates.set("point", 70);
            Connection.save(filter, update);
        }
    }

    public static boolean findLogin(User user ){
        try {
            if (Connection.find(user.getEmail()).isEmpty()) {
                return true;
            }
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public static boolean verify(User user){
        if (CardGameService.findLogin(user)){
            Bson filter = Filters.eq("_id", user.getEmail());
            Bson update = Updates.set("point", 0);
            Connection.save(filter, update);
            return false;
        }else{
            Connection.insert(user);
            return true;
        }
    }
}