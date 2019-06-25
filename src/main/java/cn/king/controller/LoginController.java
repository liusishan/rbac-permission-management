package cn.king.controller;

import cn.king.common.http.HttpResult;
import cn.king.common.http.HttpStatus;
import cn.king.entities.Permission;
import cn.king.entities.User;
import cn.king.service.PermissionService;
import cn.king.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * @author: wjl@king.cn
 * @createTime: 2019/6/14 16:55
 * @title:
 * @description:
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private PermissionService permissionService;

    /**
     * @author: wjl@king.cn
     * @createTime: 2019/6/17 15:35
     * @param: [user, session]
     * @return: cn.king.common.http.HttpResult
     * @description: 异步登录
     */
    @ResponseBody
    @PostMapping("/doAJAXLogin")
    public HttpResult doAJAXLogin(User user, HttpSession session) {
        User dbUser = userService.findUserByLogin(user);
        if (dbUser != null) {
            // 获取用户id
            Integer userId = dbUser.getId();
            // 将用户信息存入session
            session.setAttribute("loginUser", dbUser);
            //将db中的权限信息放入session
            Set<String> userPermissionUrlSet = permissionService.findPermissionsStringByUser(userId, session);
            session.setAttribute("authUriSet", userPermissionUrlSet);
            // 将权限树添加到session. 由于登录成功后需要重定向到main.html, 因此存入session;
            Permission rootPermission = permissionService.findPermissionsTreeByUser(userId);
            session.setAttribute("rootPermission", rootPermission);
            return HttpResult.ok();
        } else {
            return HttpResult.error(HttpStatus.SC_BAD_REQUEST, "用户名或密码错误");
        }
    }

    /**
     * @author: wjl@king.cn
     * @createTime: 2019/6/18 16:06
     * @param: []
     * @return: java.lang.String
     * @description: 退出方法
     */
    @ResponseBody
    @GetMapping("/logout")
    public void logout(HttpSession session){
        //按照session名清空指定session
        //session.removeAttribute("loginUser");
        //让所有session失效-- 清空所有session数据
        session.invalidate();
        //return "redirect:/login";
    }

    /**
     * @author: wjl@king.cn
     * @createTime: 2019/6/16 21:10
     * @param: []
     * @return: java.lang.String
     * @description: 跳转到登录页面
     */
    @GetMapping("/login")
    public String toLoginPage() {
        return "login";
    }

    /**
     * @author: wjl@king.cn
     * @createTime: 2019/6/16 21:16
     * @param: []
     * @return: java.lang.String
     * @description: 跳转到注册页面
     */
    @GetMapping("/register")
    public String toRegisterPage() {
        return "register";
    }

}
