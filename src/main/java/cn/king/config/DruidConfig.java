package cn.king.config;
                                                                                
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: wjl@king.cn
 * @createTime: 2019/6/14 12:31
 * @title:
 * @description:
 */
@Configuration
public class DruidConfig {

    // 创建druid数据库连接池, 注册到IOC容器中
    @Bean(name = "druid")
    // 将配置文件中的spring.datasource配置的值自动注入到DruidDataSource中的对应属性中
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return new DruidDataSource();
    }

    // 配置 druid 的监控, 这样就能使用浏览器进入数据源的监控管理系统了. 配置需要两个步骤:
    // 1. 首先需要配置一个管理后台的Servlet
    // 2. 然后需要配置一个监控的filter

    //1.
    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean servletRegistrationBean
                = new ServletRegistrationBean();
        // 注册StatViewServlet这个Servlet
        servletRegistrationBean.setServlet(new StatViewServlet());
        // 带有"/druid/*"的请求全部使用StatViewServlet这个Servlet处理
        servletRegistrationBean.setUrlMappings(Arrays.asList("/druid/*"));
        // 配置StatViewServlet这个Servlet的初始化参数
        Map<String, String> initParameters = new HashMap<>();
        initParameters.put("loginUsername", "admin");// 登录后台时需要用到的用户名
        initParameters.put("loginPassword", "123456");// 登录后台时需要用到的密码
        initParameters.put("allow", "127.0.0.1");// 允许谁访问后台
        //initParameters.put("allow", "");// 允许所有用户访问后台
        initParameters.put("deny", "192.168.15.21");// 拒绝哪些用户访问后台
        servletRegistrationBean.setInitParameters(initParameters);
        return servletRegistrationBean;
    }

    //2.
    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean filterRegistrationBean
                = new FilterRegistrationBean();
        // 注册WebStatFilter这个Filter
        filterRegistrationBean.setFilter(new WebStatFilter());
        // 设置WebStatFilter这个Filter要拦截哪些请求. 下面是拦截所有请求
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
        // 配置WebStatFilter这个Filter的初始化参数
        Map<String, String> initParameters = new HashMap<>();
        initParameters.put("exclusions", "*.js,*.css,/druid/*");// 不拦截哪些请求
        filterRegistrationBean.setInitParameters(initParameters);
        return filterRegistrationBean;
    }

}
