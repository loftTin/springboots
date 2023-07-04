package com_bjut.blog.service;

import com_bjut.blog.domain.ResponseResult;
import com_bjut.blog.domain.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface BlogLoginService {
    ResponseResult login(User user);

    ResponseResult logout();
}
