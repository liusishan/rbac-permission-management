package cn.king.service;

import cn.king.common.inter.BaseService;
import cn.king.entities.Permission;
import cn.king.entities.User;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Set;

/**
 * @author: wcj@king.cn
 * @createTime: 2019/6/14 16:34
 * @title:
 * @description:
 */
public interface PermissionService extends BaseService<Permission> {
    /**
     * 查询某用户所有的权限
     *
     * @param userId
     * @return
     */
    List<Permission> findPermissionsByUser(Integer userId);

    /**
     * 加载所有的权限树的数据
     *
     * @return
     */
    Permission loadData();

    /**
     * @author: wcj@king.cn
     * @createTime: 2019/6/20 17:53
     * @param: [roleId]
     * @return: cn.king.entities.Permission
     * @description: 取系统中所有的权限信息树, 如果该角色拥有这个权限,
     * 那么将这个的选中状态设置为T.
     */
    Permission loadAssignData(Integer roleId);

    /**
     * @author: wcj@king.cn
     * @createTime: 2019/6/20 17:54
     * @param: [userId, session]
     * @return: java.util.Set<java.lang.String>
     * @description: 获取用户的权限url封装到set集合中
     */
    Set<String> findPermissionsStringByUser(Integer userId, HttpSession session);

    /**
     * 获取某个用户的权限树
     *
     * @param userId
     * @return
     */
    Permission findPermissionsTreeByUser(Integer userId);

    /**
     * 根据主键删除某个权限
     *
     * @param permissionId
     * @return
     */
    Integer deletePermissionById(Integer permissionId);

    /**
     * @author: wcj@king.cn
     * @createTime: 2019/6/23 17:24
     * @param: [permission]
     * @return: java.lang.Integer
     * @description: 添加一个权限信息
     */
    Integer insertPermission(Permission permission, HttpSession session);

    /**
     * @author: wcj@king.cn
     * @createTime: 2019/6/24 8:57
     * @param: [permission]
     * @return: java.lang.Integer
     * @description: 修改权限信息
     */
    Integer updatePermission(Permission permission,HttpSession session);

    /**
     * @author: wcj@king.cn
     * @createTime: 2019/6/24 9:23
     * @param: []
     * @return: java.util.List<cn.king.entities.Permission>
     * @description: 获取所有的权限信息
     */
    List<Permission> selectAllPermissions();

}
