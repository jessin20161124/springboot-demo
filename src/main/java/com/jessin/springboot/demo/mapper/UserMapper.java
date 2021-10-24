package com.jessin.springboot.demo.mapper;

import com.jessin.springboot.demo.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 有了@Mapper，就不需要用@MapperScan了
 * @Author: jessinguo
 * @Date: 2021/10/24 2:26 PM
 */
@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}