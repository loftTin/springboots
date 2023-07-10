package com_bjut.blog.controller;

import com_bjut.blog.domain.ResponseResult;
import com_bjut.blog.domain.entity.LoginUser;
import com_bjut.blog.domain.entity.User;
import com_bjut.blog.domain.vo.AdminUserInfoVo;
import com_bjut.blog.domain.vo.UserInfoVo;
import com_bjut.blog.enums.AppHttpCodeEnum;
import com_bjut.blog.exception.SystemException;
import com_bjut.blog.service.LoginService;
import com_bjut.blog.service.MenuService;
import com_bjut.blog.service.RoleService;
import com_bjut.blog.utils.BeanCopyUtils;
import com_bjut.blog.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;
    private MenuService menuService;
    private RoleService roleService;

    @PostMapping("/user/login")
    public ResponseResult login(@RequestBody User user){
        if(!StringUtils.hasText(user.getUserName())){
            //提示 必须要传用户名
            throw new SystemException(AppHttpCodeEnum.REQUIRE_USERNAME);
        }
        return loginService.login(user);
    }

    @GetMapping("getInfo")
    public ResponseResult<AdminUserInfoVo> getInfo(){
        //获取当前登录的用户
        LoginUser loginUser = SecurityUtils.getLoginUser();
        //根据用户ID查询权限信息
        List<String> perms = menuService.selectRoleKeyByUserId(loginUser.getUser().getId());
        //根据用户ID查询角色信息
        List <String> rolesKeyList = roleService.selectRoleKeyByUserId(loginUser.getUser().getId());

        //获取用户信息
        User user = loginUser.getUser();
        UserInfoVo userInfoVo = BeanCopyUtils.copyBean(user, UserInfoVo.class);
        //封装数据返回
        AdminUserInfoVo adminUserInfoVo = new AdminUserInfoVo(perms,rolesKeyList,userInfoVo);
        return ResponseResult.okResult(adminUserInfoVo);
    }

}