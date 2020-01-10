package cn.qiandao.shengqianyoudao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

@EnableSwagger2
@MapperScan("cn.qiandao.shengqianyoudao.mapper")
@ComponentScan(basePackages = {"cn.qiandao.shengqianyoudao.util","cn.qiandao.shengqianyoudao.service.impl"})
@SpringBootApplication
public class ShengqianyoudaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShengqianyoudaoApplication.class, args);
    }

}
