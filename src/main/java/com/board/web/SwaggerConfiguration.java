package com.board.web;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;


@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    private String version = "V1";
    private String title = "Board Api" + version;


    @Bean
    public Docket api() {
        List<ResponseMessage> responseMessages = new ArrayList<>();

        responseMessages.add(new ResponseMessageBuilder().code(200).message("OK!!").build());
        responseMessages.add(new ResponseMessageBuilder().code(500).message("서버 문제 발생 ").responseModel(new ModelRef("Error")).build());
        responseMessages.add(new ResponseMessageBuilder().code(404).message("페이지를 찾을수 없습니다 !!").build());


        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).groupName(version).select()
                .apis(RequestHandlerSelectors.basePackage("com.board.web"))
                .paths(PathSelectors.any()).build()
                .useDefaultResponseMessages(true)
                .globalResponseMessage(RequestMethod.GET, responseMessages);
    }




    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title(title)
                .description("<h3> API References for Front </h3> Swagger 를 이용한  APi")
                .contact(new Contact("Front","github", "dbsgnl1021@naver.com"))
//                .contact(new Contact("Back", "asd", "upgrademarine5@icloud.com"))
                .version("1.0").build();

    }
}
