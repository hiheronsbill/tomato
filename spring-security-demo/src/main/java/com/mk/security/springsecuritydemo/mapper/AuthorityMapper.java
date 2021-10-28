package com.mk.security.springsecuritydemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mk.security.springsecuritydemo.entity.Authority;
import org.springframework.stereotype.Repository;


@Repository
public interface AuthorityMapper extends BaseMapper<Authority> {
}
