package cn.king.config;

import cn.king.interceptor.AuthorizationInterceptor;
import cn.king.interceptor.AuthenticateInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: wcj@king.cn
 * @createTime: 2019/6/16 12:39
 * @title:
 * @description:
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * @author: wjl@king.cn
     * @createTime: 2019/6/24 9:53
     * @param: []
     * @return: cn.king.interceptor.AuthenticateInterceptor
     * @description: 在boot中使用拦截器, 要先将拦截器注册到IOC容器中,
     * 然后再使用下面的addInterceptors注册拦截器.
     */
    @Bean
    public AuthenticateInterceptor authenticateInterceptor() {
        return new AuthenticateInterceptor();
    }

    @Bean
    public AuthorizationInterceptor authorizationInterceptor() {
        return new AuthorizationInterceptor();
    }

    private String[] pathPatternsForAuthen = {"/**"};
    private String[] excludePathPatternsForAuthen = {"/index", "/doAJAXLogin", "/login", "/bootstrap/**", "/fonts/**", "/img/**", "/jquery/**", "/layer/**", "/script/**", "/ztree/**", "/layui/**", "/**/*.css"};
    private String[] pathPatternsForAuthor = {"/**"};
    private String[] excludePathPatternsForAuthor = {"/index", "/doAJAXLogin", "/login", "/bootstrap/**", "/fonts/**", "/img/**", "/jquery/**", "/layer/**", "/script/**", "/ztree/**", "/layui/**", "/**/*.css"};

    /**
     * @author: wjl@king.cn
     * @createTime: 2019/6/16 12:39
     * @param: [registry]
     * @return: void
     * @description: 添加拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 登录拦截器
        registry.addInterceptor(authenticateInterceptor())
                .addPathPatterns(pathPatternsForAuthen)
                .excludePathPatterns(excludePathPatternsForAuthen);
        // 权限拦截器
        registry.addInterceptor(authorizationInterceptor())
                .addPathPatterns(pathPatternsForAuthor)
                .excludePathPatterns(excludePathPatternsForAuthor);
    }

}
