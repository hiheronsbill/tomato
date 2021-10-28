package com.meike.mongodb.repository;

import com.meike.mongodb.entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @Desc
 *      继承MongoRepository接口，泛型1是对应的实体类、泛型2是该类对应的文档主键
 * @Author zhxy
 * @Date 2021/10/22 09:36
 * @Version V1.0
 **/

@Repository
public interface EmployeeRepository extends MongoRepository<Employee,String> {


}
