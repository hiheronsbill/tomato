package com.mk.mybatis.service;

import com.mk.mybatis.entity.Users;

import java.util.List;

/**
 * @Desc TODO
 * @Author zhxy
 * @Date 2021/10/27 17:17
 * @Version V1.0
 **/
public interface UserService {

    List<Users> findAll();

    List<Users> findByIds(List<String> ids);

    int update(Users users);

    int insertSelective(Users users);

    int insertBatch(List<Users> users);

    int deleteById(Integer id);
}
