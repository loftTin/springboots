package com_bjut.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com_bjut.blog.domain.entity.Tag;
import com_bjut.blog.mapper.TagMapper;
import com_bjut.blog.service.TagService;
import org.springframework.stereotype.Service;

/**
 * 标签(Tag)表服务实现类
 *
 * @author makejava
 * @since 2023-07-07 14:44:31
 */
@Service("tagService")
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {

}

