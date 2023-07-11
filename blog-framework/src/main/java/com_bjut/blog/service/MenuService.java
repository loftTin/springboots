package com_bjut.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com_bjut.blog.domain.entity.Menu;

import java.util.List;


/**
 * 菜单权限表(Menu)表服务接口
 *
 * @author makejava
 * @since 2023-07-10 15:49:46
 */
public interface MenuService extends IService<Menu> {

    List<String> selectRoleKeyByUserId(Long id);
}

