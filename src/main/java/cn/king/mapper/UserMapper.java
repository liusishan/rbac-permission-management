package cn.king.mapper;
                                                                      
import cn.king.entities.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author: wjl@king.cn
 * @createTime: 2019/6/14 16:43
 * @title:
 * @description: 注意: 为了统一, 多个参数全部以Map传参
 */
public interface UserMapper {

    /**
     * @param user
     * @return
     */
    User findUserByLoginInfo(User user);

    /**
     * @return
     */
    List<User> findAll();

    /**
     * @param user
     * @return
     */
    Integer insertUser(User user);

    /**
     * @param id
     * @return
     */
    User findUserById(Integer id);

    /**
     * @param user
     * @return
     */
    Integer updateUser(User user);

    /**
     * @param id
     * @return
     */
    Integer deleteUserById(Integer id);


    /**
     * @param map
     * @return 要求传入的参数是:
     * Integer[] userIds
     * Ma<String,Object> map = new HashMap<String, Object>();
     * map.put("userIds", userIds);
     */
    Integer deleteUsersByIds(Map<String, Object> map);

    /**
     * 查询某角色下所有的用户
     *
     * @param roleId
     * @return
     */
    List<User> findUsersByRoleId(Integer roleId);

    /**
     * 分页
     *
     * @param user
     * @param pageNumber
     * @param limit
     * @return
     */
    List<User> userPaging(@Param("user") User user,
                          @Param("pageNumber") Integer pageNumber,
                          @Param("limit") Integer limit);

    /**
     * 获取部门总数
     *
     * @param user
     * @return
     */
    Long findUserCount(@Param("user") User user);

    /**
     * 根据扽古账号获取用户信息
     *
     * @param account
     * @return
     */
    User findUserByAccount(String account);


}
