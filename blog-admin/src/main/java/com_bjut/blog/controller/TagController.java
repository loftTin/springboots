package com_bjut.blog.controller;


import com_bjut.blog.domain.ResponseResult;
import com_bjut.blog.domain.dto.TagListDto;
import com_bjut.blog.domain.vo.PageVo;
import com_bjut.blog.domain.vo.TagVo;
import com_bjut.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 标签(Tag)表控制层
 *
 * @author makejava
 * @since 2023-07-07 14:47:25
 */
@RestController
@RequestMapping("/content/tag")
public class TagController {
    @Autowired
    private TagService tagService;

    @GetMapping("/list")
    public ResponseResult<PageVo> list(Integer pageNum, Integer pageSize, TagListDto tagListDto){
        return tagService.pageTagList(pageNum,pageSize,tagListDto);
    }

    @PostMapping
    private ResponseResult addTag(@RequestBody TagListDto tagListDto){
        return tagService.addTag(tagListDto);
    }

    @DeleteMapping("/{id}")
    public ResponseResult<Object> deleteTag(@PathVariable("id") List<Long> id) {
        System.out.println("删除："+id);
        return tagService.deleteTag(id);
    }

    @GetMapping("/{id}")
    public ResponseResult getLableById(@PathVariable Long id){
        return tagService.getLableById(id);
    }

    @PutMapping
    public ResponseResult updateById(@RequestBody TagVo tagVo){
        return tagService.myUpdateById(tagVo);
    }
}




