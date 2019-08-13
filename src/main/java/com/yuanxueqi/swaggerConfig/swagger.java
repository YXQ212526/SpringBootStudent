package com.yuanxueqi.swaggerConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@ComponentScan(basePackages = "com.yuanxueqi.controller")
public class swagger {
  @Bean
  public Docket createExample()
  {
    return new Docket(DocumentationType.SWAGGER_2).apiInfo(myInfo());
  }

  private ApiInfo myInfo(){
    Contact contact=new Contact("雪琪","无","18804621950@163.com");
    return new ApiInfoBuilder()
        .contact(contact)
        .description("测试")
        .title("学生管理系统")
        .build();
  }
}
