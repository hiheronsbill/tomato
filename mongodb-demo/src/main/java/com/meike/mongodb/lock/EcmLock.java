//package com.meike.mongodb.lock;
//
//import com.meike.mongodb.util.MongoUtil;
//import com.meike.mongodb.util.SpringUtil;
//import com.mongodb.reactivestreams.client.MongoCollection;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.dao.DuplicateKeyException;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.query.Criteria;
//import org.springframework.data.mongodb.core.query.Query;
//
//import java.util.concurrent.TimeUnit;
//import java.util.concurrent.locks.Condition;
//import java.util.concurrent.locks.Lock;
//
///**
// * @Author yhj
// * @create 2021/7/22
// */
//public class EcmLock implements Lock {
//
//    private Logger logger = LoggerFactory.getLogger(EcmLock.class);
//    private String key;
//    private static final String LOCK_NAME = "lock";
//    private static final int DEFAULT_EXPIRE_SECONDS = 1800;
//    EcmLock(String key)  {
//        this.key = key;
//    }
//
//    @Override
//    public void lock() {
//        if (!tryLock()) {
//            getLock(DEFAULT_EXPIRE_SECONDS);
//        }
//
//    }
//
//    @Override
//    public void lockInterruptibly() {
//        throw new UnsupportedOperationException();
//    }
//
//    @Override
//    public boolean tryLock() {
//        MongoLock lock = new MongoLock(key);
//        try {
//            MongoCollection collection = MongoUtil.getMongoCollection(LOCK_NAME);
////            collection.insertOne(lock).subscribe();
//            return true;
//        }catch (DuplicateKeyException e) {
//            return false;
//        }
//    }
//
//
//
//    @Override
//    public boolean tryLock(long time, TimeUnit unit) {
//        long l = unit.toSeconds(time);
//        return tryAcquire(l);
//    }
//
//
//
//    @Override
//    public void unlock() {
//        try{
//            MongoTemplate mongoTemplate = SpringUtil.getBean(MongoTemplate.class);
//            mongoTemplate.remove(new Query(Criteria.where("key").is(key)), MongoLock.class);
//        }catch (Exception e) {
//            logger.error(e.getMessage(), e);
//        }
//    }
//
//    @Override
//    public Condition newCondition() {
//        throw new UnsupportedOperationException();
//    }
//
//    private boolean getLock(long time) {
//        try {
//            while (time > 0) {
//                TimeUnit.SECONDS.sleep(1);
//                time--;
//                if (tryLock()) {
//                    return true;
//                }
//            }
//
//        }catch (Exception e) {
//            logger.error(e.getMessage(), e);
//        }
//
//        return false;
//    }
//
//    private boolean tryAcquire(long time) {
//        return tryLock() || getLock(time);
//    }
//}
