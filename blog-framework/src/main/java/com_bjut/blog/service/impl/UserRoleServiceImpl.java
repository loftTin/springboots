package com_bjut.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com_bjut.blog.domain.entity.UserRole;
import com_bjut.blog.mapper.UserRoleMapper;
import com_bjut.blog.service.UserRoleService;
import org.springframework.stereotype.Service;


@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {
}
