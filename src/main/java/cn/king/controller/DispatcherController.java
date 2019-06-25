package cn.king.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: wjl@king.cn
 * @createTime: 2019/6/16 12:38
 * @title:
 * @description: 调度的控制器, 作用专门用来跳转某些页面
 */
@Controller
public class DispatcherController {

    /**
     * @author: wjl@king.cn
     * @createTime: 2019/6/18 16:40
     * @param: []
     * @return: java.lang.String
     * @description: 跳转到系统主页
     */
    @GetMapping("/sys/index")
    public String indexMain() {
        return "main";
    }

    /**
     * @author: wjl@king.cn
     * @createTime: 2019/6/16 19:16
     * @param: []
     * @return: java.lang.String
     * @description: 跳转到用户维护页面
     */
    @GetMapping("/sys/user")
    public String indexUser() {
        return "user/index";
    }

    /**
     * @author: wjl@king.cn
     * @createTime: 2019/6/16 20:21
     * @param: []
     * @return: java.lang.String
     * @description: 跳转到角色维护页面
     */
    @GetMapping("/sys/role")
    public String indexRole() {
        return "role/index";
    }

    /**
     * @author: wjl@king.cn
     * @createTime: 2019/6/16 20:21
     * @param: []
     * @return: java.lang.String
     * @description: 跳转到权限维护界面
     */
    @GetMapping("/sys/permission")
    public String indexPermission() {
        return "permission/index";
    }










}
