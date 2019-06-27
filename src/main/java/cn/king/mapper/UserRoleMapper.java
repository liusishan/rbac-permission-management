package cn.king.mapper;
                                                                   
import java.util.Map;

/**
 * @author: wjl@king.cn
 * @createTime: 2019/6/14 16:44
 * @title:
 * @description:
 */
public interface UserRoleMapper {

    /**
     * 给用户赋予角色
     * @param map
     * @return
     * 前台传过来的是:
     * 			Map<String,Object>map = new HashMap<>();
     * 			map.put("userId", userId);
     * 			map.put("roleIds", unAssignRoleIds);
     *
     * 		public Object doUnAssign(Integer userId, Integer[]  assignRoleIds) {
     */
    Integer insertUserRoles(Map<String, Object> map);

    /**
     * 删除用户对应的个别角色信息. 就是削减用户的权限;
     * @param map
     * @return
     * 前台传过来的是:
     * 			Map<String,Object>map = new HashMap<>();
     * 			map.put("userId", userId);
     * 			map.put("roleIds", assignRoleIds);
     * 			userService.deleteUserRoles(map);
     *
     * public Object doUnAssign(Integer userId, Integer[]  assignRoleIds)
     */
    Integer deleteUserRoles(Map<String, Object> map);

    /**
     * @author: wjl@king.cn
     * @createTime: 2019/6/18 17:39
     * @param: [userId]
     * @return: java.lang.Integer
     * @description: 删除用户对应的所有角色数据.
     * 适用于删除用户后, 为了删除用户角色表中对应的数据;
     */
    Integer deleteUserAllRoles(Integer userId);

    /**
     * @author: wjl@king.cn
     * @createTime: 2019/6/18 17:46
     * @param: [roleId]
     * @return: java.lang.Integer
     * @description: 删除角色对应的所有用户数据.
     * 适用于删除角色后, 为了删除用户角色表中对应的数据;
     */
    Integer deleteRoleAllUsers(Integer roleId);
}
