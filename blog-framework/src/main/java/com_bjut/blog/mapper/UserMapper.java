package com_bjut.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com_bjut.blog.domain.entity.User;
import org.springframework.stereotype.Repository;


/**
 * 用户表(User)表数据库访问层
 *
 * @author makejava
 * @since 2023-07-03 11:09:34
 */

@Repository(value = "userMapper")
public interface UserMapper extends BaseMapper<User> {

}

