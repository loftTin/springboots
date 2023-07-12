package com_bjut.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com_bjut.blog.domain.entity.RoleMenu;


public interface RoleMenuService extends IService<RoleMenu> {

    void deleteRoleMenuByRoleId(Long id);
}