package com.mk.mybatis.service.impl;

import com.mk.mybatis.entity.Users;
import com.mk.mybatis.mapper.UsersMapper;
import com.mk.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Desc TODO
 * @Author zhxy
 * @Date 2021/10/27 17:49
 * @Version V1.0
 **/

@Service
public class UserServicesImpl implements UserService {


    @Autowired
    private UsersMapper usersMapper;


    @Override
    public List<Users> findAll() {
        return usersMapper.findAll();
    }

    @Override
    public List<Users> findByIds(List<String> ids) {
        return usersMapper.findByIds(ids);
    }

    @Override
    public int update(Users users) {
        return usersMapper.updateBySelective(users);
    }

    @Override
    public int insertSelective(Users users) {
        return usersMapper.insertSelective(users);
    }

    @Override
    public int insertBatch(List<Users> users) {
        return usersMapper.insertBatch(users);
    }

    @Override
    public int deleteById(Integer id) {
        return usersMapper.deleteById(id);
    }
}
