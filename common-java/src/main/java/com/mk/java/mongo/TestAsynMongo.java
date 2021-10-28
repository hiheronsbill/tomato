package com.mk.java.mongo;

import com.mongodb.reactivestreams.client.*;
import org.bson.Document;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/**
 * @Desc TODO
 * @Author zhxy
 * @Date 2021/9/20 15:25
 * @Version V1.0
 **/
public class TestAsynMongo {


    public static void main(String[] args) throws InterruptedException {

        MongoClient mongoClient = MongoClients.create();

        MongoDatabase mongo = mongoClient.getDatabase("mongo");

        MongoCollection<Document> employee = mongo.getCollection("employee");

        FindPublisher<Document> publisher = employee.find();

        publisher.subscribe(new SubscriberHelpers.PrintDocumentSubscriber());


//        publisher.subscribe(new Subscriber<Document>() {
//            @Override
//            public void onSubscribe(Subscription s) {
//                System.out.println("start...");
//                //执行请求
//                s.request(Integer.MAX_VALUE);
//            }
//
//            @Override
//            public void onNext(Document document) {
//                //获得文档
//                System.out.println("Document:" + document.toJson());
//            }
//
//            @Override
//            public void onError(Throwable t) {
//                System.out.println("error occurs.");
//            }
//
//            @Override
//            public void onComplete() {
//                System.out.println("finished.");
//            }
//        });
//
//        Thread.sleep(50000l);

    }
}
