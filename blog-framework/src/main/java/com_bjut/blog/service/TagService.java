package com_bjut.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com_bjut.blog.domain.ResponseResult;
import com_bjut.blog.domain.dto.TagListDto;
import com_bjut.blog.domain.entity.Tag;
import com_bjut.blog.domain.vo.PageVo;
import com_bjut.blog.domain.vo.TagVo;

import java.util.List;


/**
 * 标签(Tag)表服务接口
 *
 * @author makejava
 * @since 2023-07-07 14:44:31
 */
public interface TagService extends IService<Tag> {

    ResponseResult<PageVo> pageTagList(Integer pageNum, Integer pageSize, TagListDto tagListDto);

    ResponseResult addTag(TagListDto tagListDto);

    ResponseResult deleteTag(List<Long> id);

    ResponseResult getLableById(Long id);

    ResponseResult myUpdateById(TagVo tagVo);

    List<TagVo> listAllTag();
}


