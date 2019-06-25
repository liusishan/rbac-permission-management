package cn.king.service;

import cn.king.common.inter.BaseService;
import cn.king.entities.UserRole;

/**
 * @author: wjl@king.cn
 * @createTime: 2019/6/14 16:34
 * @title:
 * @description:
 */
public interface UserRoleService extends BaseService<UserRole> {
    Integer assignUserRoles(Integer userId, Integer[] roleIds, Integer type);
}
