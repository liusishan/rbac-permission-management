package cn.king.service.impl;

import cn.king.entities.Permission;
import cn.king.mapper.PermissionMapper;
import cn.king.mapper.RolePermissionMapper;
import cn.king.service.PermissionService;
import cn.king.utils.BaseFieldsSetValueUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * @author: wjl@king.cn
 * @createTime: 2019/6/14 16:40
 * @title:
 * @description:
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;
    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    @Override
    @Transactional
    public int insert(Permission record) {
        return 0;
    }

    @Override
    @Transactional
    public int delete(Permission record) {
        return 0;
    }

    @Override
    @Transactional
    public int delete(List<Permission> records) {
        return 0;
    }

    @Override
    public Permission findById(Integer id) {
        if (id == null) {
            return null;
        }
        return permissionMapper.findPermissionById(id);
    }

    @Override
    public List<Permission> findAll() {
        return null;
    }

    @Override
    public Map<String, Object> paging(Permission permission, Integer pageNumber, Integer limit) {
        return null;
    }

    @Override
    public Long findCount(Permission permission) {
        return null;
    }

    /**
     * @author: wjl@king.cn
     * @createTime: 2019/6/20 17:13
     * @param: [userId]
     * @return: java.util.List<cn.king.entities.Permission>
     * @description: 获取某用户数据库中的全部权限信息
     */
    @Override
    public List<Permission> findPermissionsByUser(Integer userId) {
        return permissionMapper.findPermissionsByUserId(userId);
    }

    /**
     * @author: wjl@king.cn
     * @createTime: 2019/6/20 14:59
     * @param: []
     * @return: java.lang.Object
     * @description: 加载系统所有的权限信息, 并封装成树
     */
    @Override
    public Permission loadData() {
        // 获取根节点
        Permission rootPermission = permissionMapper.findRootPermission();
        // 获取根节点下所有的子节点并拼装到根节点上
        findChildPermissions(rootPermission);
        return rootPermission;
    }

    /**
     * @author: wjl@king.cn
     * @createTime: 2019/6/20 15:21
     * @param: [roleid]
     * @return: java.lang.Object
     * @description: 加载系统所有的权限信息, 并封装成树.
     * 如果某个权限信息是该角色所有, 那么就将这个权限的选中状态设置为T.
     */
    @Override
    public Permission loadAssignData(Integer roleId) {
        // 查询系统中所有的权限数据
        List<Permission> allPermissions = permissionMapper.findAllPermissions();
        // 获取当前角色已经分配的权限的id
        List<Integer> permissionsIds = permissionMapper.findPermissionsIdsByRoleId(roleId);
        if (permissionsIds == null) {
            return null;
        }
        // 将已经分配给角色的权限的选中状态设置为T
        for (Permission sysPermission : allPermissions) {
            // 如果当前角色拥有这个权限
            if (permissionsIds.contains(sysPermission.getId())) {
                // 设置选中状态为T
                sysPermission.setChecked(true);
            } else {
                sysPermission.setChecked(false);
            }
        }
        return piecePermissionTree(allPermissions);
    }

    /**
     * @author: wjl@king.cn
     * @createTime: 2019/6/20 17:33
     * @param: [userId, session 为了在权限url前拼接应用名, 因此需要session]
     * @return: java.util.Set<java.lang.String>
     * @description: 获取用户的权限url封装到set集合中
     */
    @Override
    public Set<String> findPermissionsStringByUser(Integer userId, HttpSession session) {
        // 获取数据库中某个用户的权限信息
        List<Permission> dbPermissions = findPermissionsByUser(userId);
        // 将用户权限保存到set中, set是不能重复的list
        Set<String> userPermissionUrlSet = new HashSet<>();
        for (Permission permission : dbPermissions) {
            if (permission.getUrl() != null && !"".equals(permission.getUrl())) {
                // 将权限信息去重并添加上完整项目名后存入Set集合(元素不能重复的List集合)
                userPermissionUrlSet.add(session.getServletContext().getContextPath() + permission.getUrl());
            }
        }
        return userPermissionUrlSet;
    }

    /**
     * @author: wjl@king.cn
     * @createTime: 2019/6/20 17:03
     * @param: [user]
     * @return: cn.king.entities.Permission
     * @description: 获取某个用户的权限树
     */
    @Override
    public Permission findPermissionsTreeByUser(Integer userId) {
        List<Permission> userPermissionList = permissionMapper.findPermissionsByUserId(userId);
        if (userPermissionList == null) {
            return null;
        }
        return piecePermissionTree(userPermissionList);
    }

    /**
     * @author: wjl@king.cn
     * @createTime: 2019/6/23 14:55
     * @param: [permissionId]
     * @return: java.lang.Integer
     * @description: 根据主键删除权限表中的权限信息
     */
    @Override
    @Transactional
    public Integer deletePermissionById(Integer permissionId) {
        if (permissionId == null) {
            return null;
        }
        // 1. 删除权限表中对应的权限
        permissionMapper.deletePermissionById(permissionId);
        // 2. 删除角色权限关系表中对应的数据
        rolePermissionMapper.deleteRelationshipByPermissionId(permissionId);
        return 0;
    }

    /**
     * @author: wjl@king.cn
     * @createTime: 2019/6/23 17:24
     * @param: [permission]
     * @return: java.lang.Integer
     * @description: 添加一个新的权限
     */
    @Override
    @Transactional
    public Integer insertPermission(Permission permission, HttpSession session) {
        Map<String, String> map = BaseFieldsSetValueUtils.setBaseFields(session);
        String by = map.get("by");
        String time = map.get("time");
        permission.setCreateBy(by);
        permission.setCreateTime(time);
        permission.setLastUpdateBy(by);
        permission.setLastUpdateTime(time);
        permission.setDelFlag(0);
        return permissionMapper.insertPermission(permission);
    }

    /**
     * @author: wjl@king.cn
     * @createTime: 2019/6/24 8:58
     * @param: [permission]
     * @return: java.lang.Integer
     * @description: 更新权限信息
     */
    @Override
    @Transactional
    public Integer updatePermission(Permission permission, HttpSession session) {
        Map<String, String> map = BaseFieldsSetValueUtils.setBaseFields(session);
        permission.setLastUpdateBy(map.get("by"));
        permission.setLastUpdateTime(map.get("time"));
        permissionMapper.updatePermission(permission);
        System.out.println("修改后的权限信息-------------------------");
        System.out.println(permission);
        return 1;
    }

    /**
     * @author: wjl@king.cn
     * @createTime: 2019/6/24 9:23
     * @param: []
     * @return: java.util.List<cn.king.entities.Permission>
     * @description: 获取所有的权限信息
     */
    @Override
    public List<Permission> selectAllPermissions() {
        return permissionMapper.findAllPermissions();
    }

    /**
     * @author: wjl@king.cn
     * @createTime: 2019/6/22 14:46
     * @param: [permissionList 查询出的前权限集合]
     * @return: cn.king.entities.Permission
     * @description: 拼装权限树
     * 我们将权限的list集合拼装成树
     */
    private Permission piecePermissionTree(List<Permission> permissionList) {
        if (permissionList == null) {
            return null;
        }
        Map<Integer, Permission> rolePermissionMap = new HashMap<>();
        for (Permission permission : permissionList) {
            rolePermissionMap.put(permission.getId(), permission);
        }
        Permission rootPermission = null;
        for (Permission permission : permissionList) {
            //首先将每个许可都当作子节点
            Permission child;
            child = permission;
            //找到顶级节点
            if (child.getParentId() == 0) {
                rootPermission = child;
            } else {
                //找到父节点
                Permission parent = rolePermissionMap.get(child.getParentId());
                //整合父子节点关系
                parent.getChildren().add(child);
            }
        }
        return rootPermission;
    }

    /**
     * @author: wjl@king.cn
     * @createTime: 2019/6/20 17:08
     * @param: [parent]
     * @return: void
     * @description: 递归获取某节点下面的所有子节点并拼装到该节点上
     */
    private void findChildPermissions(Permission parent) {
        // 根据父菜单查询子菜单
        List<Permission> childPermissions
                = permissionMapper.findChildPermissions(parent.getId());
        // 根据子菜单得到孙菜单
        for (Permission childPermission : childPermissions) {
            // 递归
            findChildPermissions(childPermission);
        }
        // 将子菜单放到父菜单中
        parent.setChildren(childPermissions);
    }


}
