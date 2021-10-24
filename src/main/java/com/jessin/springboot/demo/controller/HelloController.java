package com.jessin.springboot.demo.controller;

import com.jessin.springboot.demo.model.User;
import com.jessin.springboot.demo.service.UserService;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: jessinguo
 * @Date: 2021/10/24 1:16 PM
 */
@RestController
@Slf4j
public class HelloController {
    @Resource
    private UserService userService;

    @RequestMapping("/hello")
    public String hello() {
        log.debug("run hello controller");
        return "hello world spring boot";
    }

    /**
     * http://localhost:9999/practice/user?id=1
     * @param id
     * @return
     */
    @RequestMapping("/user")
    public User getUser(@RequestParam Long id) {
        User user = userService.queryUser(id);
        log.debug("查询id：{}，对应的用户为：{}", id, user);
        return user;
    }

    /**
     * http://localhost:9999/practice/insertUser?name=jessin&age=1&sex=1&note=test
     * @param user
     * @return
     */
    @RequestMapping("/insertUser")
    public User insertUser(User user) {
        boolean result = userService.insert(user);
        log.debug("插入用户：{}，结果为：{}", user, result);
        return user;
    }
}
