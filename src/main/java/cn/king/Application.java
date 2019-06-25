package cn.king;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan(basePackages = {"cn.king.mapper"})
@SpringBootApplication
@EnableAsync
@EnableTransactionManagement
public class Application {

    public static void main(String[] args) {
        // 去掉boot启动时的Logo
        SpringApplication springApplication = new SpringApplication(Application.class);
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(args);
    }

}


