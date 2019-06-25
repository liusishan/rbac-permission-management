package cn.king.controller;

import cn.king.common.http.HttpResult;
import cn.king.entities.User;
import cn.king.service.RoleService;
import cn.king.service.UserRoleService;
import cn.king.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author: wjl@king.cn
 * @createTime: 2019/6/14 16:48
 * @title:
 * @description:
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserRoleService userRoleService;

    /**
     * @author: wjl@king.cn
     * @createTime: 2019/6/19 10:27
     * @param: [user, pageNumber, limit]
     * @return: java.lang.Object
     * @description: 分页
     */
    @ResponseBody
    @GetMapping("/userPaging")
    public Object userPaging(User user,
                             @RequestParam(value = "page", required = false, defaultValue = "1") Integer pageNumber,
                             @RequestParam(value = "limit", required = false, defaultValue = "10") Integer limit) {
        Map<String, Object> pagingData = userService.paging(user, pageNumber, limit);
        // 成功的状态码要求为0
        pagingData.put("code", 0);
        pagingData.put("msg", "");
        return pagingData;
    }

    /**
     * @author: wjl@king.cn
     * @createTime: 2019/6/19 17:19
     * @param: [userId]
     * @return: cn.king.common.http.HttpResult
     * @description: 获取用户的角色信息
     */
    @ResponseBody
    @PostMapping("/getUserRoles")
    public HttpResult getUserRoles(Integer userId) {
        Map<String, Object> userRoles = roleService.getUserRoles(userId);
        return HttpResult.ok(userRoles);
    }

    /**
     * @author: wjl@king.cn
     * @createTime: 2019/6/19 20:42
     * @param: [userId, roleIds, type]
     * @return: cn.king.common.http.HttpResult
     * @description: 分配角色,
     * 如果type=0, 就是添加角色,
     * 如果type=1, 就是取消角色
     */
    @ResponseBody
    @PostMapping("/assignUserRoles")
    public HttpResult assignUserRoles(Integer userId, Integer[] roleIds, Integer type) {
        return HttpResult.ok(userRoleService.assignUserRoles(userId, roleIds, type));
    }

    /**
     * @author: wjl@king.cn
     * @createTime: 2019/6/17 14:14
     * @param: []
     * @return: java.lang.String
     * @description: 跳转到角色分配页面
     */
    @GetMapping("/assign/{userId}")
    public String toAssignRolePage(@PathVariable("userId") Integer userId, Model model) {
        model.addAttribute("userId", userId);
        return "user/assign";
    }

    /**
     * @author: wjl@king.cn
     * @createTime: 2019/6/17 15:01
     * @param: []
     * @return: java.lang.String
     * @description: 跳转到用户添加页面
     */
    @ResponseBody
    @PostMapping("/add")
    public HttpResult add(User user, HttpSession session) {
        return HttpResult.ok(userService.insertUser(user, session));
    }

}

