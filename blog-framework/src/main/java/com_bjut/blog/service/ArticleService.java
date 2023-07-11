package com_bjut.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com_bjut.blog.domain.ResponseResult;
import com_bjut.blog.domain.dto.AddArticleDto;
import com_bjut.blog.domain.entity.Article;
import org.springframework.stereotype.Service;

/**
 * 文章表(Article)表服务接口
 *
 * @author makejava
 * @since 2023-06-28 09:45:40
 */
@Service
public interface ArticleService extends IService<Article> {
    ResponseResult hotArticleList();

    ResponseResult articleList(Integer pageNum, Integer pageSize, Long categoryId);

    ResponseResult getArticleDetail(Long id);

    ResponseResult updateViewCount(Long id);

    ResponseResult add(AddArticleDto article);
}

