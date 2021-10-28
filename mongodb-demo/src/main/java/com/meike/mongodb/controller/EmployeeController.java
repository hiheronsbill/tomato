package com.meike.mongodb.controller;

import com.meike.mongodb.entity.Employee;
import com.meike.mongodb.repository.EmployeeRepository;
import com.meike.mongodb.util.JsonResult;
import com.meike.mongodb.util.TenantHolder;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * @Description 控制器
 * @Author zhxy
 * @Date 2021/8/4 14:10
 **/

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

//    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private AccessTestAop accessTestAop;

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping(value = "")
    public JsonResult list() {
        setTenantCode();
//        List<Employee> employeeList = mongoTemplate.findAll(Employee.class, "employee");
//
//        for (Method declaredMethod : mongoTemplate.getClass().getMethods()) {
//            System.out.println(declaredMethod.getName());
//        }
        List<Employee> employeeList = employeeRepository.findAll();

        return new JsonResult(true, employeeList);
    }

    @RequestMapping("/findId")
    public JsonResult findById(@RequestParam("id") String id) {
        setTenantCode();
        Employee employee = mongoTemplate.findById(id, Employee.class, "employee");
        return new JsonResult(true, employee);
    }

    @PostMapping(value = "")
    public JsonResult add(Employee employee) {
        setTenantCode();

        accessTestAop.testNoArgs();

        String msg = verifySaveForm(employee);
        if (!StringUtils.isEmpty(msg)) {
            return new JsonResult(false, msg);
        }
        if (employee.getId() == null) {
            employee.setCreateTime(new Date());
            employee.setLastUpdateTime(new Date());
            Collection<Employee> newEmployee = mongoTemplate.insert(Arrays.asList(employee), Employee.class);
//            Employee newEmployee = mongoTemplate.insert(employee);
            return new JsonResult(true, newEmployee);
        } else {
            Query query = new Query();
            query.addCriteria(Criteria.where("_id").is(employee.getId()));

            Update update = new Update();
            update.set("name", employee.getName());
            update.set("password", employee.getPassword());
            update.set("address", employee.getAddress());
            update.set("last_update_time", new Date());

            UpdateResult updateResult = mongoTemplate.updateFirst(query, update, "user");
            return new JsonResult(true, updateResult);
        }
    }

    @DeleteMapping(value = "{id}")
    public JsonResult delete(@PathVariable String id) {
        setTenantCode();

        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        Employee one = mongoTemplate.findOne(query, Employee.class);
        DeleteResult remove = mongoTemplate.remove(one);
        return new JsonResult(true);
    }

    /**
     * 验证对象字段值
     *
     * @param employee
     * @return
     */
    private String verifySaveForm(Employee employee) {
        if (employee == null || StringUtils.isEmpty(employee.getName())) {
            return "员工名不能为空";
        } else if (employee.getPassword() == null) {
            return "密码不能为空";
        }
        return null;
    }

    public void setTenantCode() {
        TenantHolder.keepTenant("1234");
    }


    @RequestMapping("/access")
    public String testAccessAop(){
        accessTestAop.testNoArgs();
        accessTestAop.testDefault();
        return "";
    }

}
