package com.meike.mongo2.mongo2demo.entity;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/**
 * @Desc TODO
 * @Author zhxy
 * @Date 2021/10/22 17:40
 * @Version V1.0
 **/

@Data
@Document("employee")
public class Employee {

    @Id
    private String id;

    @Field("name")
    private String name;

    @Field("password")
    private String password;

    @Field("address")
    private String address;

    @Field("create_time")
    private Date createTime;

    @Field("last_update_time")
    private Date lastUpdateTime;


    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
