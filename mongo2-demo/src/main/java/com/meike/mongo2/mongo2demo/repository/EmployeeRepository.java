package com.meike.mongo2.mongo2demo.repository;

import com.meike.mongo2.mongo2demo.entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @Desc TODO
 * @Author zhxy
 * @Date 2021/10/22 17:43
 * @Version V1.0
 **/
public interface EmployeeRepository extends MongoRepository<Employee, String> {
}
