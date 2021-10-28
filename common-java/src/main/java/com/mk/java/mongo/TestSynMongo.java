package com.mk.java.mongo;


import com.mongodb.client.*;
import org.bson.Document;

/**
 * @Desc TODO
 * @Author zhxy
 * @Date 2021/9/20 14:48
 * @Version V1.0
 **/
public class TestSynMongo {

    public static void main(String[] args){


        MongoClient mongoClient = MongoClients.create();
        MongoDatabase mongo = mongoClient.getDatabase("mongo");
        MongoCollection<Document> employee = mongo.getCollection("employee");

        MongoCursor<Document> iterator = employee.find().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toJson());
        }

    }

}
