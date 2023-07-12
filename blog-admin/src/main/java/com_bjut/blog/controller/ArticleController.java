package com_bjut.blog.controller;

import com_bjut.blog.domain.ResponseResult;
import com_bjut.blog.domain.dto.AddArticleDto;
import com_bjut.blog.domain.dto.ArticleDto;
import com_bjut.blog.domain.entity.Article;
import com_bjut.blog.domain.vo.ArticleVo;
import com_bjut.blog.domain.vo.PageVo;
import com_bjut.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/content/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping
    public ResponseResult add(@RequestBody AddArticleDto article){
        return articleService.add(article);
    }

    @GetMapping("/list")
    public ResponseResult list(Article article, Integer pageNum, Integer pageSize)
    {
        PageVo pageVo = articleService.selectArticlePage(article,pageNum,pageSize);
        return ResponseResult.okResult(pageVo);
    }

    @GetMapping(value = "/{id}")
    public ResponseResult getInfo(@PathVariable(value = "id")Long id){
        ArticleVo article = articleService.getInfo(id);
        return ResponseResult.okResult(article);
    }

    @PutMapping
    public ResponseResult edit(@RequestBody ArticleDto article){
        articleService.edit(article);
        return ResponseResult.okResult();
    }
    @DeleteMapping("/{id}")
    public ResponseResult delete(@PathVariable Long id){
        articleService.removeById(id);
        return ResponseResult.okResult();
    }
}
