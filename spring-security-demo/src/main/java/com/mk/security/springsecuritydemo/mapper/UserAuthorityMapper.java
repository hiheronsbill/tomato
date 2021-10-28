package com.mk.security.springsecuritydemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mk.security.springsecuritydemo.entity.UserAuthority;
import org.springframework.stereotype.Repository;


@Repository
public interface UserAuthorityMapper extends BaseMapper<UserAuthority> {
}
