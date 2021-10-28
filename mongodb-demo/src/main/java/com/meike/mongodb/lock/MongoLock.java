package com.meike.mongodb.lock;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @Author yhj
 * @create 2021/9/18
 */
@Document(collection = "lock")
@Setter
@Getter
public class MongoLock{
    @Indexed(unique = true)
    private String key;

    @Indexed(expireAfterSeconds=0)
    private Date expireAt;

    public MongoLock(String key) {
        this.key = key;
        expireAt = new Date(System.currentTimeMillis() + 1800 * 1000L);
    }
}
