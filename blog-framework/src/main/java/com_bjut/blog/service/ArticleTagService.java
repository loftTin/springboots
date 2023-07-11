package com_bjut.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com_bjut.blog.domain.entity.Article;
import com_bjut.blog.domain.entity.ArticleTag;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ArticleTagService extends IService<Article> {

    void saveBatch(List<ArticleTag> articleTags);
}

