package cn.king.controller;

import cn.king.common.http.HttpResult;
import cn.king.common.http.HttpStatus;
import cn.king.entities.Permission;
import cn.king.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author: wjl@king.cn
 * @createTime: 2019/6/14 16:48
 * @title:
 * @description:
 */
@Controller
@RequestMapping("permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    /**
     * @author: wjl@king.cn
     * @createTime: 2019/6/24 8:47
     * @param: [permission]
     * @return: cn.king.common.http.HttpResult
     * @description: 修改权限
     */
    @ResponseBody
    @PostMapping("/edit")
    public HttpResult edit(Permission permission,HttpSession session) {
        return HttpResult.ok(permissionService.updatePermission(permission, session));
    }

    /**
     * @author: wjl@king.cn
     * @createTime: 2019/6/23 17:26
     * @param: [permission]
     * @return: cn.king.common.http.HttpResult
     * @description: 添加一个新权限
     */
    @ResponseBody
    @PostMapping("/insertPermission")
    public HttpResult insertPermission(Permission permission, HttpSession session) {
        Integer i = permissionService.insertPermission(permission, session);

        if (i == null) {
            return HttpResult.error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "服务器错误");
        }
        return HttpResult.ok();
    }

    /**
     * @author: wjl@king.cn
     * @createTime: 2019/6/22 15:10
     * @param: []
     * @return: cn.king.entities.Permission
     * @description: 获取系统中所有的权限信息树
     */
    @ResponseBody
    @PostMapping("/loadData")
    public Permission loadData() {
        return permissionService.loadData();
    }

    /**
     * @author: wjl@king.cn
     * @createTime: 2019/6/20 15:48
     * @param: [roleid]
     * @return: cn.king.entities.Permission
     * @description: 获取系统中所有的权限信息树, 如果该角色拥有这个权限,
     * 那么将这个的选中状态设置为T.
     * <p>
     * 不能返回HttpResult, 因为ztree要求必须返回特性接口的json用来渲染树.
     */
    @ResponseBody
    @PostMapping("/loadAssignData")
    public Permission loadAssignData(Integer roleId) {
        return permissionService.loadAssignData(roleId);
    }

    /**
     * @author: wjl@king.cn
     * @createTime: 2019/6/23 15:05
     * @param: [permissionId]
     * @return: cn.king.common.http.HttpResult
     * @description: 删除权限信息
     */
    @ResponseBody
    @PostMapping("/delete")
    public HttpResult delete(Integer permissionId) {
        return HttpResult.ok(permissionService.deletePermissionById(permissionId));
    }

    /**
     * @author: wjl@king.cn
     * @createTime: 2019/6/23 14:48
     * @param: [id]
     * @return: java.lang.String
     * @description: 跳转到权限修改页面
     */
    @GetMapping("/edit/{id}")
    public String toPermissionEditPage(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("id", id);
        return "permission/edit";
    }

    /**
     * @author: wjl@king.cn
     * @createTime: 2019/6/23 14:44
     * @param: [parentNodeId]
     * @return: java.lang.String
     * @description: 跳转到权限添加页面
     */
    @GetMapping("/add/{parentNodeId}")
    public String toPermissionAddPage(@PathVariable("parentNodeId") Integer parentNodeId, Model model) {
        model.addAttribute("parentId", parentNodeId);
        return "permission/add";
    }

    /**
     * @author: wjl@king.cn
     * @createTime: 2019/6/23 20:21
     * @param: [id]
     * @return: cn.king.common.http.HttpResult
     * @description: 根据id查找权限
     */
    @ResponseBody
    @GetMapping("/find")
    public HttpResult findById(Integer id) {
        return HttpResult.ok(permissionService.findById(id));
    }


}
