package com_bjut.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com_bjut.blog.domain.entity.Role;

import java.util.List;


/**
 * 角色信息表(Role)表数据库访问层
 *
 * @author makejava
 * @since 2023-07-10 16:00:24
 */
public interface RoleMapper extends BaseMapper<Role> {

    List<String> selectRoleKeyByUserId(Long userId);

    List<Long> selectRoleIdByUserId(Long userId);
}

