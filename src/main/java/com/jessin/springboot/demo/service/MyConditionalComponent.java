package com.jessin.springboot.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

/**
 * @Author: jessin
 * @Date: 2022/3/27 6:04 下午
 */
@Component
@ConditionalOnProperty(name = "old.man", havingValue = "true")
@Slf4j
public class MyConditionalComponent {

    public MyConditionalComponent() {
        log.info("I am constructed");
    }
}
