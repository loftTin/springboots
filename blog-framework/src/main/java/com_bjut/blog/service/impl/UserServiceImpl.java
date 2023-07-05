package com_bjut.blog.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com_bjut.blog.domain.ResponseResult;
import com_bjut.blog.domain.entity.User;
import com_bjut.blog.domain.vo.UserInfoVo;
import com_bjut.blog.enums.AppHttpCodeEnum;
import com_bjut.blog.exception.SystemException;
import com_bjut.blog.mapper.UserMapper;
import com_bjut.blog.service.UserService;
import com_bjut.blog.utils.BeanCopyUtils;
import com_bjut.blog.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * 用户表(User)表服务实现类
 *
 * @author makejava
 * @since 2023-07-04 15:18:25
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public ResponseResult userInfo() {
        //获取当前用户id
        Long userId = SecurityUtils.getUserId();
        //根据用户id查询用户信息
        User user = getById(userId);
        //封装成UserInfoVo
        UserInfoVo vo = BeanCopyUtils.copyBean(user,UserInfoVo.class);
        return ResponseResult.okResult(vo);
    }

    @Override
    public ResponseResult updateUserInfo(User user) {
        updateById(user);
        return ResponseResult.okResult();
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public ResponseResult register(User user) {
        //对数据进行非空判断
        if(!StringUtils.hasText(user.getUserName())){
            throw new SystemException(AppHttpCodeEnum.USERNAME_NOT_NULL);
        }
        if(!StringUtils.hasText(user.getPassword())){
            throw new SystemException(AppHttpCodeEnum.PASSWORD_NOT_NULL);
        }
        if(!StringUtils.hasText(user.getEmail())){
            throw new SystemException(AppHttpCodeEnum.EMAIL_NOT_NULL);
        }
        if(!StringUtils.hasText(user.getNickName())){
            throw new SystemException(AppHttpCodeEnum.NICKNAME_NOT_NULL);
        }
        //对数据进行是否存在的判断
//        if(userNameExist(user.getUserName())){
//            throw new SystemException(AppHttpCodeEnum.USERNAME_EXIST);
//        }
//        if(nickNameExist(user.getNickName())){
//            throw new SystemException(AppHttpCodeEnum.NICKNAME_EXIST);
//        }
//        if(phonenumberExist(user.getPhonenumber())){
//            throw new SystemException(AppHttpCodeEnum.PHONENUMBER_EXIST);
//        }
//        if(emailExist(user.getEmail())){
//            throw new SystemException(AppHttpCodeEnum.EMAIL_EXIST);
//        }
        //对密码进行加密
        String encodePassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodePassword);
        //存入数据库
        save(user);
        return ResponseResult.okResult();
    }

//    private boolean userNameExist(String userName) {
//        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
//        queryWrapper.eq(User::getUserName, userName);
//        return count(queryWrapper)>0;
//    }
//
//    private boolean nickNameExist(String nickName) {
//        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
//        queryWrapper.eq(User::getNickName, nickName);
//        return count(queryWrapper)>0;
//    }
//
//    private boolean phonenumberExist(String phonenumber) {
//        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
//        queryWrapper.eq(User::getPhonenumber, phonenumber);
//        return count(queryWrapper)>0;
//    }
//    private boolean emailExist(String email) {
//        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
//        queryWrapper.eq(User::getEmail, email);
//        return count(queryWrapper)>0;
//    }

}

