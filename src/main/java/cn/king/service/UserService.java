package cn.king.service;

import cn.king.common.inter.BaseService;
import cn.king.entities.User;

import javax.servlet.http.HttpSession;

/**
 * @author: wjl@king.cn
 * @createTime: 2019/6/14 16:34
 * @title:
 * @description:
 */
public interface UserService extends BaseService<User> {
    /**
     * 根据登录的用户名密码查询用户信息
     *
     * @param user
     * @return
     */
    User findUserByLogin(User user);

    /**
     * 添加用户
     * @param user
     * @param session
     * @return
     */
    Integer insertUser(User user, HttpSession session);




}
