package cn.king.service.impl;

import cn.king.entities.Role;
import cn.king.mapper.RoleMapper;
import cn.king.service.RoleService;
import cn.king.utils.PagingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author: wcj@king.cn
 * @createTime: 2019/6/14 16:41
 * @title:
 * @description:
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    @Transactional
    public int insert(Role record) {
        return 0;
    }

    @Override
    @Transactional
    public int delete(Role record) {
        return 0;
    }

    @Override
    @Transactional
    public int delete(List<Role> records) {
        return 0;
    }

    @Override
    public Role findById(Integer id) {
        return null;
    }


    @Override
    public List<Role> findAll() {
        return roleMapper.findAll();
    }

    /**
     * @author: wcj@king.cn
     * @createTime: 2019/6/20 12:39
     * @param: [role, pageNumber, limit]
     * @return: java.util.Map<java.lang.String, java.lang.Object>
     * @description: 分页
     */
    @Override
    public Map<String, Object> paging(Role role, Integer pageNumber, Integer limit) {
        List<Role> roleList = roleMapper.rolePaging(role, (pageNumber - 1) * limit, limit);
        Long roleCount = roleMapper.findRoleCount(role);
        return PagingUtils.pagingData(roleList, roleCount);
    }

    @Override
    public Long findCount(Role role) {
        return null;
    }

    /**
     * @author: wcj@king.cn
     * @createTime: 2019/6/19 17:22
     * @param: [userId]
     * @return: java.util.List<cn.king.entities.Role>
     * @description: 获取用户已经有的权限
     */
    @Override
    public List<Role> findRolesByUserId(Integer userId) {
        return roleMapper.findRolesByUserId(userId);
    }

    /**
     * @author: wcj@king.cn
     * @createTime: 2019/6/19 17:27
     * @param: [userId]
     * @return: java.util.Map<java.lang.String, java.lang.Object>
     * @description: 返回用户的角色信息, 一条已经有的角色信息, 一条还没有的角色信息
     */
    @Override
    public Map<String, Object> getUserRoles(Integer userId) {
        // 系统所有的角色
        List<Role> allRoles = findAll();
        // 用户已经分配的角色
        List<Role> exitRoles = findRolesByUserId(userId);
        // 用户没有分配的角色
        List<Role> notExitRoles;

        //for (Role role : allRoles) {
        //    for (Role role1 : exitRoles) {
        //        if (!role.equals(role1)){
        //            notExitRoles.add(role);
        //        }
        //    }
        //}

        // 下面一段同上面一段
        //notExitRoles = allRoles.stream()
        //        .filter(role -> {
        //            return !exitRoles.contains(role);
        //        }).collect(Collectors.toList());

        // 下面一段同上面一段
        notExitRoles = allRoles.stream()
                // 如果不包含就过滤.
                .filter(role -> !exitRoles.contains(role)).collect(Collectors.toList());

        // 实际上, 我们的业务不需要notExitRoles. 此处的代码用来学习使用

        Map<String, Object> roleInfo = new HashMap<>();
        roleInfo.put("exitRoles", exitRoles);
        roleInfo.put("notExitRoles", notExitRoles);
        roleInfo.put("allRoles", allRoles);
        System.out.println(roleInfo);
        return roleInfo;
    }

}
