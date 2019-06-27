package cn.king.interceptor;
   
import cn.king.entities.User;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author: wjl@king.cn
 * @createTime: 2019/6/16 12:34
 * @title:
 * @description: 登录拦截器
 */
public class AuthenticateInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //判断当前用户是否已经登录
        HttpSession session = request.getSession();
        User loginUser =  (User)session.getAttribute("loginUser");
        if(loginUser == null) {
            String path = session.getServletContext().getContextPath();
            response.sendRedirect(path+"/login");
            return false;
        }else {
            return true;
        }
    }

}
