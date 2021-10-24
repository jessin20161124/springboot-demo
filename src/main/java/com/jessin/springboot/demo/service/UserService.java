package com.jessin.springboot.demo.service;

import com.jessin.springboot.demo.mapper.UserMapper;
import com.jessin.springboot.demo.model.User;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author: jessinguo
 * @Date: 2021/10/24 2:32 PM
 */
@Service
@Slf4j
public class UserService {

    @Resource
    private UserMapper userMapper;

    public User queryUser(Long id) {
        User user = userMapper.selectByPrimaryKey(id);
        log.info("查询用户id：{}，返回：{}", id, user);
        return user;
    }

    public boolean insert(User user) {
        return userMapper.insertSelective(user) == 1;
    }
}
