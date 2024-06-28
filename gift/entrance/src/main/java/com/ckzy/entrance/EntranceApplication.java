package com.ckzy.entrance;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@ComponentScan("com.ckzy")
@MapperScan(basePackages = "com.ckzy.dao")
@SpringBootApplication
@EnableWebMvc
@EnableSwagger2WebMvc
//@Import({InterceptorConfig.class, SwaggerConfiguration.class})
public class EntranceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EntranceApplication.class, args);
    }

}
