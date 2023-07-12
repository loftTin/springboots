package com_bjut.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com_bjut.blog.domain.ResponseResult;
import com_bjut.blog.domain.entity.Link;
import com_bjut.blog.domain.vo.PageVo;

public interface LinkService extends IService<Link> {

    ResponseResult getAllLink();

    PageVo selectLinkPage(Link link, Integer pageNum, Integer pageSize);
}

