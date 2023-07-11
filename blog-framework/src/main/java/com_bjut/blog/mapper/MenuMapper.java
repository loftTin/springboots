package com_bjut.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com_bjut.blog.domain.entity.Menu;

import java.util.List;


/**
 * 菜单权限表(Menu)表数据库访问层
 *
 * @author makejava
 * @since 2023-07-10 15:49:46
 */
public interface MenuMapper extends BaseMapper<Menu> {

    List<String> selectPermsByUserId(Long id);
}

