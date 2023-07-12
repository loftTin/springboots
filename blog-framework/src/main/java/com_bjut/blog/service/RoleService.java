package com_bjut.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com_bjut.blog.domain.ResponseResult;
import com_bjut.blog.domain.entity.Role;

import java.util.List;


/**
 * 角色信息表(Role)表服务接口
 *
 * @author makejava
 * @since 2023-07-10 16:00:22
 */
public interface RoleService extends IService<Role> {

    List<String> selectRoleKeyByUserId(Long id);

    ResponseResult selectRolePage(Role role, Integer pageNum, Integer pageSize);

    void insertRole(Role role);

    void updateRole(Role role);

    List<Role> selectRoleAll();

    List<Long> selectRoleIdByUserId(Long userId);
}

