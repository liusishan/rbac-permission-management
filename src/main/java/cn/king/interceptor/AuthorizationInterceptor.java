package cn.king.interceptor;

import cn.king.entities.Permission;
import cn.king.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: wjl@king.cn
 * @createTime: 2019/6/16 12:36
 * @title:
 * @description: 权限拦截器
 */
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private PermissionService permissionService;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler)throws Exception {
        // 获取用户当前请求地址, 以便验证用户是否有权限访问
        // -- 用户请求的路径
        String uri = request.getRequestURI();
        // -- 项目名
        String path = request.getSession().getServletContext().getContextPath();
        // 判断当前路径是否需要进行权限验证, 公共路径不需要权限即可访问
        // -- 获取所有需要验证权限信息的路径集合
        List<Permission> permissions = permissionService.selectAllPermissions();

        //将所有的权限放到map集合中, set是不可重复的map集合
        Set<String> uriSet = new HashSet<>();
        for ( Permission permission : permissions ) {
            if ( permission.getUrl() != null && !"".equals(permission.getUrl()) ) {
                uriSet.add(path + permission.getUrl());
            }
        }

        //如果所有需要授权才能访问的路径中包含了用户当前请求的路径, 说明当前的请求需要进行权限验证
        if ( uriSet.contains(uri) ) {
            // 权限验证
            // 判断当前用户是否拥有访问该url的权限
            //取出当前用户所有权限
            Set<String> authUriSet =
                    (Set<String>)request.getSession().getAttribute("authUriSet");
            if ( authUriSet.contains(uri) ) {
                //如果用户的所有许可中, 包含当前的许可
                //放行
                return true;
            } else {
                //如果用户的所有许可中没有当前的许可
                //重定向到主页页面
                response.sendRedirect(path + "/login");
                return false;
            }
            //不包含, 说明这个url不需要授权即可访问
        } else {
            return true;
        }
    }

}
