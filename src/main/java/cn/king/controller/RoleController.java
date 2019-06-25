package cn.king.controller;

import cn.king.common.http.HttpResult;
import cn.king.entities.Role;
import cn.king.service.RolePermissionService;
import cn.king.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author: wjl@king.cn
 * @createTime: 2019/6/14 16:48
 * @title:
 * @description:
 */
@Controller
@RequestMapping("role")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private RolePermissionService rolePermissionService;

    /**
     * @author: wjl@king.cn
     * @createTime: 2019/6/17 15:24
     * @param: []
     * @return: cn.king.common.http.HttpResult
     * @description:
     */
    @GetMapping("/findAll")
    public HttpResult findAll() {
        return HttpResult.ok(roleService.findAll());
    }

    /**
     * @author: wjl@king.cn
     * @createTime: 2019/6/20 12:37
     * @param: [role, pageNumber, limit]
     * @return: java.lang.Object
     * @description: 分页
     */
    @ResponseBody
    @GetMapping("/rolePaging")
    public Object rolePaging(Role role,
                             @RequestParam(value = "page", required = false, defaultValue = "1") Integer pageNumber,
                             @RequestParam(value = "limit", required = false, defaultValue = "10") Integer limit) {
        Map<String, Object> pagingData = roleService.paging(role, pageNumber, limit);
        // 成功的状态码要求为0
        pagingData.put("code", 0);
        pagingData.put("msg", "");
        return pagingData;
    }

    /**
     * @author: wjl@king.cn
     * @createTime: 2019/6/22 13:37
     * @param: []
     * @return: cn.king.common.http.HttpResult
     * @description: 给角色分配权限
     */
    @ResponseBody
    @PostMapping("/doAssign")
    public HttpResult doAssign(Integer roleId, Integer[] permissionsIds) {
        return HttpResult.ok(rolePermissionService.insertRolePermissions(roleId, permissionsIds));
    }

    /**
     * @author: wjl@king.cn
     * @createTime: 2019/6/17 15:23
     * @param: []
     * @return: java.lang.String
     * @description: 跳转到权限分配页面
     */
    @GetMapping("/assign/{roleId}")
    public String toAssignPermissionPage(@PathVariable("roleId")Integer roleId, Model model) {
        model.addAttribute("roleId", roleId);
        return "role/assign";
    }

}
