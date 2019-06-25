package cn.king.service;

import cn.king.common.inter.BaseService;
import cn.king.entities.Role;
import cn.king.utils.PagingUtils;

import java.util.List;
import java.util.Map;

/**
 * @author: wjl@king.cn
 * @createTime: 2019/6/14 16:34
 * @title:
 * @description:
 */
public interface RoleService extends BaseService<Role> {
    /**
     * 获取用户已经有的角色
     * @param userId
     * @return
     */
    List<Role> findRolesByUserId(Integer userId);

    /**
     * 返回用户的角色信息, 一条已经有的角色信息, 一条还没有的角色信息
     * @param userId
     * @return
     */
    Map<String, Object> getUserRoles(Integer userId);


}
