package cn.king.service.impl;

import cn.king.entities.RolePermission;
import cn.king.mapper.RolePermissionMapper;
import cn.king.service.RolePermissionService;
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
public class RolePermissionServiceImpl implements RolePermissionService {

    @Autowired
    private RolePermissionMapper  rolePermissionMapper;

    @Override
    @Transactional
    public int insert(RolePermission record) {
        return 0;
    }

    @Override
    @Transactional
    public int delete(RolePermission record) {
        return 0;
    }

    @Override
    @Transactional
    public int delete(List<RolePermission> records) {
        return 0;
    }

    @Override
    public RolePermission findById(Integer id) {
        return null;
    }

    @Override
    public List<RolePermission> findAll() {
        return null;
    }

    @Override
    public Map<String, Object> paging(RolePermission rolePermission, Integer pageNumber, Integer limit) {
        return null;
    }

    @Override
    public Long findCount(RolePermission rolePermission) {
        return null;
    }

    /**
     * @author: wjl@king.cn
     * @createTime: 2019/6/22 14:10
     * @param: [map]
     * @return: java.lang.Integer
     * @description: 给角色分配权限
     */
    @Override
    @Transactional
    public Integer insertRolePermissions(Integer roleId, Integer[] permissionsIds) {
        // 先删除当前角色所有的权限
        rolePermissionMapper.deleteRoleAllPermissions(roleId);
        // 再给当前角色分配新的权限
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("roleId", roleId);
        paramMap.put("permissionsIds", permissionsIds);
       return rolePermissionMapper.insertRolePermissions(paramMap);
    }

}
