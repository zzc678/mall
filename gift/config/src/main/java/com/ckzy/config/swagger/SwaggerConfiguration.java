package com.ckzy.config.swagger;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


@Configuration
@SuppressWarnings("all")
public class SwaggerConfiguration {
    @Bean
    public Docket defaultApi() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("测试版本")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ckzy.web.controller"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("创客资源（深圳）信息技术有限公司开发文档")
                .description("福礼铺子商城项目")
                .termsOfServiceUrl("https://ckzy.com")
                .contact(new Contact("创客资源（深圳）信息技术有限公司", "https://www.ckzy.com", "ckzy@163.com"))
                .version("1.0")
                .build();
    }
}
