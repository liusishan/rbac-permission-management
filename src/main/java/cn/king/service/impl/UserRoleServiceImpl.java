package cn.king.service.impl;

import cn.king.entities.UserRole;
import cn.king.mapper.UserRoleMapper;
import cn.king.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: wjl@king.cn
 * @createTime: 2019/6/14 16:41
 * @title:
 * @description:
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    @Transactional
    public int insert(UserRole record) {
        return 0;
    }

    @Override
    @Transactional
    public int delete(UserRole record) {
        return 0;
    }

    @Override
    @Transactional
    public int delete(List<UserRole> records) {
        return 0;
    }

    @Override
    public UserRole findById(Integer id) {
        return null;
    }


    @Override
    public List<UserRole> findAll() {
        return null;
    }

    @Override
    public Map<String, Object> paging(UserRole userRole, Integer pageNumber, Integer limit) {
        return null;
    }

    @Override
    public Long findCount(UserRole userRole) {
        return null;
    }

    /**
     * @author: wjl@king.cn
     * @createTime: 2019/6/19 20:43
     * @param: [userId, roleIds, type]
     * @return: java.lang.Integer
     * @description:
     */
    @Override
    public Integer assignUserRoles(Integer userId, Integer[] roleIds, Integer type) {
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("roleIds", roleIds);
        if (type == 0) {
            return userRoleMapper.insertUserRoles(map);
        }
        if (type == 1) {
            return userRoleMapper.deleteUserRoles(map);
        }
        return null;
    }
}
