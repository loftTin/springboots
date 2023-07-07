package com_bjut.blog.service;

import com_bjut.blog.domain.ResponseResult;
import com_bjut.blog.domain.entity.User;

public interface LoginService {
    ResponseResult login(User user);

}
