package com.meike.mongodb;

import com.meike.mongodb.entity.Employee;
import com.meike.mongodb.entity.User;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.Date;
import java.util.List;

@SpringBootTest
class MongodbTests {

    @Autowired
    private MongoTemplate mongoTemplate;


    @Test
    public void test(){
//        List<Employee> employees = mongoTemplate.find(new Query(Criteria.where("create_time").lt(new Date())), Employee.class);
//        employees.forEach(System.out::println);
        /*-----------------------------------------*/
//        Employee employee = mongoTemplate.findOne(new Query(Criteria.where("create_time").lt(new Date())), Employee.class);
//        System.out.println(employee);
        /*-----------------------------------------*/
//        List<Employee> employees = mongoTemplate.findAll(Employee.class);
//        employees.forEach(System.out::println);
        /*-----------------------------------------*/

    }


    @Test
    public void test1() {
//        List<User> userList = mongoTemplate.findAll(User.class);
//        if (userList != null && userList.size() > 0) {
//            userList.stream().forEach(System.out::println);
//        }

        ObjectId objectId = new ObjectId("5e7d9e967e0d0d3dce9a2f5f");
        System.out.println(objectId);
    }


    @Test
    public void test2(){
        ObjectId objectId = new ObjectId();
        System.out.println(objectId.toString());
        System.out.println(new ObjectId(objectId.toString()));
        System.out.println(new ObjectId(objectId.toString()));
    }

}
