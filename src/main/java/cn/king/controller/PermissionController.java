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
 * @author: wcj
 */
@Controller
@RequestMapping("permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    /**
     * @author: wcj
     */
    @ResponseBody
    @PostMapping("/edit")
    public HttpResult edit(Permission permission,HttpSession session) {
        return HttpResult.ok(permissionService.updatePermission(permission, session));
    }

    /**
     * @author: wcj
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
     * @author: wcj
     */
    @ResponseBody
    @PostMapping("/loadData")
    public Permission loadData() {
        return permissionService.loadData();
    }

    /**
     * @author: wcj
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
     * @author: wcj
     * 删除权限信息
     */
    @ResponseBody
    @PostMapping("/delete")
    public HttpResult delete(Integer permissionId) {
        return HttpResult.ok(permissionService.deletePermissionById(permissionId));
    }

    /**
     跳转到权限修改页面
     */
    @GetMapping("/edit/{id}")
    public String toPermissionEditPage(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("id", id);
        return "permission/edit";
    }

    /**
     * @author: wcj
     */
    @GetMapping("/add/{parentNodeId}")
    public String toPermissionAddPage(@PathVariable("parentNodeId") Integer parentNodeId, Model model) {
        model.addAttribute("parentId", parentNodeId);
        return "permission/add";
    }

    /**
     * @author: wcj
     根据id查找权限
     */
    @ResponseBody
    @GetMapping("/find")
    public HttpResult findById(Integer id) {
        return HttpResult.ok(permissionService.findById(id));
    }


}
