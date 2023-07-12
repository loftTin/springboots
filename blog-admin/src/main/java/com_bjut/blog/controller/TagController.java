package com_bjut.blog.controller;


import com_bjut.blog.domain.ResponseResult;
import com_bjut.blog.domain.dto.AddTagDto;
import com_bjut.blog.domain.dto.EditTagDto;
import com_bjut.blog.domain.dto.TagListDto;
import com_bjut.blog.domain.entity.Tag;
import com_bjut.blog.domain.vo.PageVo;
import com_bjut.blog.domain.vo.TagVo;
import com_bjut.blog.service.TagService;
import com_bjut.blog.utils.BeanCopyUtils;
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
    public ResponseResult add(@RequestBody AddTagDto tagDto){
        Tag tag = BeanCopyUtils.copyBean(tagDto, Tag.class);
        tagService.save(tag);
        return ResponseResult.okResult();
    }

    @DeleteMapping("/{id}")
    public ResponseResult delete(@PathVariable Long id){
        tagService.removeById(id);
        return ResponseResult.okResult();
    }

    @PutMapping
    public ResponseResult edit(@RequestBody EditTagDto tagDto){
        Tag tag = BeanCopyUtils.copyBean(tagDto,Tag.class);
        tagService.updateById(tag);
        return ResponseResult.okResult();
    }


    @GetMapping(value = "/{id}")
    public ResponseResult getInfo(@PathVariable(value = "id")Long id){
        Tag tag = tagService.getById(id);
        return ResponseResult.okResult(tag);
    }


    @GetMapping("/listAllTag")
    public ResponseResult listAllTag(){
        List<TagVo> list = tagService.listAllTag();
        return ResponseResult.okResult(list);
    }
}




