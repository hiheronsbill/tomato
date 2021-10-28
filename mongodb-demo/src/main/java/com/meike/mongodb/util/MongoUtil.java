//package com.meike.mongodb.util;
//
//import com.mongodb.reactivestreams.client.MongoClient;
//import com.mongodb.reactivestreams.client.MongoCollection;
//import com.mongodb.reactivestreams.client.MongoDatabase;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
///**
// * @Desc TODO
// * @Author zhxy
// * @Date 2021/9/21 23:27
// * @Version V1.0
// **/
//public class MongoUtil {
//
//    private static final String MONGO_DATABASE = "mongo";
//
//    private static volatile MongoClient mongoClient;
//
//    private static MongoClient getMongoClient() {
//        if (mongoClient == null) {
//            synchronized (MongoUtil.class) {
//                if (mongoClient == null) {
//                    mongoClient = SpringUtil.getBean(MongoClient.class);
//                }
//            }
//        }
//        return mongoClient;
//    }
//
//    public static MongoCollection getMongoCollection(String collection) {
//        return getMongoCollection(MONGO_DATABASE, collection);
//    }
//
//    public static MongoCollection getMongoCollection(String database, String collection) {
//        return getMongoClient().getDatabase(database).getCollection(collection);
//    }
//
//}
