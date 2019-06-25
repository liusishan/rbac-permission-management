package cn.king.mapper;

import cn.king.entities.Role;
import cn.king.entities.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: wjl@king.cn
 * @createTime: 2019/6/14 16:44
 * @title:
 * @description:
 */
public interface RoleMapper {
    /**
     * 查询所有的角色
     *
     * @return
     */
    List<Role> findAll();

    /**
     * 查询某用户的所有角色
     *
     * @param userId
     * @return
     */
    List<Role> findRolesByUserId(Integer userId);

    /**
     * 查询某权限被哪些角色所拥有
     *
     * @param permissionId
     * @return
     */
    List<Role> findRolesByPermissionId(Integer permissionId);

    /**
     *
     * @param roleId
     * @return
     */
    Role findRoleById(Integer roleId);

    /**
     *
     * @param roleId
     * @return
     */
    Integer deleteRoleById(Integer roleId);

    /**
     *
     * @param role
     * @return
     */
    Integer updateRole(Role role);

    /**
     *
     * @param role
     * @return
     */
    Integer insertRole(Role role);

    /**
     * 分页
     * @param role
     * @param pageNumber
     * @param limit
     * @return
     */
    List<Role> rolePaging(@Param("role") Role role,
                          @Param("pageNumber") Integer pageNumber,
                          @Param("limit") Integer limit);

    /**
     * @author: wjl@king.cn
     * @createTime: 2019/6/20 12:44
     * @param: [role]
     * @return: java.lang.Long
     * @description:
     */
    Long findRoleCount(@Param("role") Role role);

}
