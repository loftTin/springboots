package com_bjut.blog.job;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com_bjut.blog.domain.entity.Article;
import com_bjut.blog.service.ArticleService;
import com_bjut.blog.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class updataViewCountJob {

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private ArticleService articleService;

//    @Scheduled(cron = "0/5 * * * * ? ")
//    @Transactional
//    public void updateViewCount(){
//        //要执行的代码
//        //获取redis中的浏览量
//        Map<String, Integer> viewCountMap = redisCache.getCacheMap("article:viewCount");
//
//        List<Article> articles = viewCountMap.entrySet()
//                .stream()
//                .map(entry -> new Article(Long.valueOf(entry.getKey()), entry.getValue().longValue()))
//                .collect(Collectors.toList());
//        //更新到数据库中
//        articleService.updateBatchById(articles);
//
//    }

    @Scheduled(cron = "0/5 * * * * ?")
    @Transactional
    public void updateViewCount() {
        // 从缓存获取浏览量
        Map<String, Integer> map = redisCache.getCacheMap("article:viewCount");
        //更新数据库
        List<Article> articles = map.entrySet().stream().map(item -> new Article(Long.valueOf(item.getKey()), Long.valueOf(item.getValue()))).collect(Collectors.toList());
        for (Article article : articles) {
            LambdaUpdateWrapper<Article> wrapper = Wrappers.lambdaUpdate(Article.class).eq(Article::getId, article.getId()).set(Article::getViewCount, article.getViewCount());
            articleService.update(wrapper);
        }

    }
}
