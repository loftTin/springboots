package com_bjut.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com_bjut.blog.domain.ResponseResult;
import com_bjut.blog.domain.entity.Category;


/**
 * 分类表(Category)表服务接口
 *
 * @author makejava
 * @since 2023-06-29 23:34:10
 */
public interface CategoryService extends IService<Category> {

    ResponseResult getCategoryList();

}

