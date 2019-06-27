package cn.king.mapper;

import java.util.Map;

/**
 * @author: wcj
 */
public interface RolePermissionMapper {

    /**
     * 给角色赋予权限
     * @param map
     * @return
     * 传的参数是:
     * 			Map<String, Object> paramMap = new HashMap<String, Object>();
     * 			paramMap.put("roleId", roleId);
     * 			paramMap.put("permissionIds", permissionIds);
     *
     * 		public Object doAssign( Integer roleId, Integer[] permissionIds ) {
     */
    Integer insertRolePermissions(Map<String, Object> map);

    /**
     * 删除角色对应的所有权限信息
     * @param map
     * @return
     */
    Integer deleteRolePermissions(Map<String, Object> map);

    /**
     * 删除权限对应的所有角色信息
     * @param map
     * @return
     */
    Integer deletePermissionRoles(Map<String, Object> map);

    /**
     删除当前角色所有的权限
     */
    Integer deleteRoleAllPermissions(Integer roleId);

    /**

    删除角色权限关系表中, 所有权限是PermissionId的记录
     */
    Integer deleteRelationshipByPermissionId(Integer permissionId);
}
