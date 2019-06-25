package cn.king.config;

import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: wjl@king.cn
 * @createTime: 2019/6/14 15:20
 * @title:
 * @description: MyBatis的配置文件. 代替xml版本的mybatis的核心配置文件.
 */
@Configuration
public class MyBatisConfig {

        /**
         * @param: []
         * @return: org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer
         * @auther: king
         * @date: 2018/10/31 10:20
         * @description: 开启驼峰命名法,
         * 数据表中字段格式xxx_yyy,实体bean中的属性可以写成xxx_yyy或xxxYyy
         */
        @Bean
        public ConfigurationCustomizer configurationCustomizer() {
            return configuration -> {
                // 开启驼峰命名自动匹配
                configuration.setMapUnderscoreToCamelCase(true);
            };
        }

}
