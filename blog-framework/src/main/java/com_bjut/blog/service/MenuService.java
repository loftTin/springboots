package com_bjut.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com_bjut.blog.domain.entity.Menu;

import java.util.List;


/**
 * 菜单权限表(Menu)表服务接口
 *
 * @author makejava
 * @since 2023-07-11 10:49:19
 */
public interface MenuService extends IService<Menu> {

    List<String> selectPermsByUserId(Long id);

    List<Menu> selectRouterMenuTreeByUserId(Long userId);

    List<Menu> selectMenuList(Menu menu);

    boolean hasChild(Long menuId);

    List<Long> selectMenuListByRoleId(Long roleId);
}

