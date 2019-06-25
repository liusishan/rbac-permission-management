package cn.king.service;

import cn.king.common.inter.BaseService;
import cn.king.entities.RolePermission;
import org.springframework.context.annotation.Primary;

import java.util.Map;

/**
 * @author: wjl@king.cn
 * @createTime: 2019/6/14 16:34
 * @title:
 * @description:
 */
public interface RolePermissionService extends BaseService<RolePermission> {
    /**
     * @author: wjl@king.cn
     * @createTime: 2019/6/22 14:10
     * @param: [map]
     * @return: java.lang.Integer
     * @description: 给角色分配权限
     */
    Integer insertRolePermissions(Integer roleId, Integer[] permissionsIds);

}
