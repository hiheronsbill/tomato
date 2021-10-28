package com.mk.security.springsecuritydemo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mk.security.springsecuritydemo.entity.Authority;
import com.mk.security.springsecuritydemo.entity.UserAuthority;
import com.mk.security.springsecuritydemo.entity.Users;
import com.mk.security.springsecuritydemo.mapper.AuthorityMapper;
import com.mk.security.springsecuritydemo.mapper.UserMapper;
import com.mk.security.springsecuritydemo.mapper.UserAuthorityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AuthorityMapper authorityMapper;

    @Autowired
    private UserAuthorityMapper userAuthorityMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {


        // 根据用户名查用户
        QueryWrapper<Users> userWrapper = new QueryWrapper<>();
        userWrapper.eq("username", s);
        Users users = userMapper.selectOne(userWrapper);
        if (users == null) {
            throw new UsernameNotFoundException("用户名不存在！！");
        }
        // 根据用户id查权限id
        QueryWrapper<UserAuthority> userRoleWrapper = new QueryWrapper<>();
        userRoleWrapper.eq("uid", users.getId());
        List<UserAuthority> userAuthorities = userAuthorityMapper.selectList(userRoleWrapper);

        List<GrantedAuthority> auths = new ArrayList<>();
        if (userAuthorities != null && userAuthorities.size() > 0) {
            List<Integer> ridList = userAuthorities.stream().map(UserAuthority::getRid).collect(Collectors.toList());
            // 根据权限id查权限，并进行封装
            QueryWrapper<Authority> roleWrapper = new QueryWrapper<>();
            roleWrapper.in("id", ridList);
            List<Authority> authorities = authorityMapper.selectList(roleWrapper);

            if (authorities != null && authorities.size() > 0) {
                authorities.forEach(authority -> {
                    auths.add(new SimpleGrantedAuthority(authority.getName()));
                });

            }
        }
        if (auths.size() < 1) {
            auths.add(new SimpleGrantedAuthority("admin"));
        }

        // 返回用户及其权限
        return new User(users.getUsername(), users.getPassword(), auths);
    }
}
