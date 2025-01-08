package com.example.CardGame.database;

import com.example.CardGame.dto.User;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;


public class Connection {

    private static final String URI = "mongodb://root:mongoInit001@localhost:27018/?appName=switch?database=switch";
    private static String DATABASE_NAME;
    private MongoClient mongoClient;
    private MongoDatabase database;
    private String collectionName = "user";

    public Connection() {
        // Configuração e inicialização do cliente MongoDB
        mongoClient = MongoClients.create(URI);
        database = mongoClient.getDatabase("picpay-desafio");
    }

    public static void insert(User user) {
        MongoCollection<Document> collection = MongoClients.create("mongodb://root:mongoInit001@localhost:27018/?appName=switch?database=switch").getDatabase("picpay-desafio").getCollection("user");
        Document document = new Document("_id", user.getEmail())
                .append("name", user.getName())
                .append("password", user.getPassword())
                .append("point", 0);
        collection.insertOne(document);
        System.out.println("Documento inserido com sucesso!");
    }

    public static void save(Bson filter, Bson update) {
        MongoCollection<Document> collection = MongoClients.create("mongodb://root:mongoInit001@localhost:27018/?appName=switch?database=switch").getDatabase("picpay-desafio").getCollection("user");
        collection.updateOne(filter, update);
        System.out.println("Documento atualizado com sucesso!");
    }

    public static Document find(String email){
        MongoClient mongoClient = MongoClients.create(URI);
        MongoDatabase database = mongoClient.getDatabase("picpay-desafio");
        MongoCollection<Document> collection = database.getCollection("user");
        Bson filter = Filters.eq("_id", email);
        Document result = collection.find(filter).first();

        return result;
    }
}