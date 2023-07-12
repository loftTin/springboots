package com_bjut.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com_bjut.blog.domain.entity.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * 菜单权限表(Menu)表数据库访问层
 *
 * @author makejava
 * @since 2023-07-11 10:49:19
 */
/**
 * 菜单权限表(Menu)表数据库访问层
 *
 * @author makejava
 * @since 2022-08-09 22:32:07
 */
@Repository(value = "menuMapper")
public interface MenuMapper extends BaseMapper<Menu> {
    List<String> selectPermsByUserId(Long userId);

    List<Menu> selectAllRouterMenu();

    List<Menu> selectRouterMenuTreeByUserId(Long userId);

    List<Long> selectMenuListByRoleId(Long roleId);
}

