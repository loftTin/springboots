package com_bjut.blog.domain.vo;

import com_bjut.blog.domain.entity.Role;
import com_bjut.blog.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 标签(Tag)表实体类
 *
 * @author makejava
 * @since 2022-07-19 22:33:36
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoAndRoleIdsVo {
    private User user;
    private List<Role> roles;
    private List<Long> roleIds;



}
