package com.mk.mybatis.mapper;

import com.mk.mybatis.entity.Users;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersMapper {

    List<Users> findAll();

    List<Users> findByIds(List<String> ids);

    int updateBySelective(Users users);

    int insertSelective(Users users);

    int insertBatch(List<Users> users);

    int deleteById(Integer id);

}