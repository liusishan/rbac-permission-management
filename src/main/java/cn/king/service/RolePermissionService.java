package cn.king.service;

import cn.king.common.inter.BaseService;
import cn.king.entities.RolePermission;
import org.springframework.context.annotation.Primary;

import java.util.Map;

/**
 * @author: wcj
 */
public interface RolePermissionService extends BaseService<RolePermission> {
    /**
     * @author: wcj@king.cn
     * @createTime: 2019/6/22 14:10
     * @param: [map]
     * @return: java.lang.Integer
     * @description: 给角色分配权限
     */
    Integer insertRolePermissions(Integer roleId, Integer[] permissionsIds);

}
