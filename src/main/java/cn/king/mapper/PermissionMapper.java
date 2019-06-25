package cn.king.mapper;

import cn.king.entities.Permission;

import java.util.List;
import java.util.Map;

/**
 * @author: wjl@king.cn
 * @createTime: 2019/6/14 16:44
 * @title:
 * @description:
 */
public interface PermissionMapper {
    /**
     * 查询某角色的所有权限
     *
     * @param roleId
     * @return
     */
    List<Permission> findPermissionsByRoleId(Integer roleId);

    /**
     * 查询某角色的所有权限的id
     *
     * @param roleId
     * @return
     */
    List<Integer> findPermissionsIdsByRoleId(Integer roleId);

    /**
     * 查询某用户所有的权限
     *
     * @param userId
     * @return
     */
    List<Permission> findPermissionsByUserId(Integer userId);

    /**
     * 查询所有权限
     *
     * @return
     */
    List<Permission> findAllPermissions();

    /**
     * 查询所有权限信息的id
     *
     * @return
     */
    List<Integer> findAllPermissionsIds();

    /**
     * 添加权限
     *
     * @param permission
     * @return
     */
    Integer insertPermission(Permission permission);

    /**
     * 根据主键查询权限信息
     *
     * @param id
     * @return
     */
    Permission findPermissionById(Integer id);

    /**
     * 更新权限信息
     *
     * @param permission
     * @return
     */
    Integer updatePermission(Permission permission);

    /**
     * 删除单个权限信息
     *
     * @param permissionId
     * @return
     */
    Integer deletePermissionById(Integer permissionId);

    /**
     * 删除多个权限信息
     *
     * @param map
     * @return
     */
    Integer deletePermissionsByIds(Map<String, Object> map);

    /**
     * 查询出根节点. 用下面的方法即可.
     *
     * @return
     */
    Permission findRootPermission();

    /**
     * 根据父节点查询子节点
     *
     * @param pid
     * @return
     */
    List<Permission> findChildPermissions(Integer pid);

}
