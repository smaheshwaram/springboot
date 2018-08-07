/* To enable the Swagger 2 we use the annotation @EnableSwagger2.
        A Docket bean is defined and using its select() method we get an instance of ApiSelectorBuilder. ApiSelectorBuilder we configure the endpoints exposed by Swagger.
        After the Docket bean is defined, its select() method returns an instance of ApiSelectorBuilder, which provides a way to control the endpoints exposed by Swagger.
        Using the RequestHandlerSelectors and PathSelectors we configure the predicates for selection of RequestHandlers.
        */

package com.hello.helloworld.swaggertest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
                .apiInfo(apiInfo()).select().paths(postPaths()).build();
    }

    private Predicate<String> postPaths() {
        return or(regex("/api/posts.*"), regex("/api/helloworld.*"));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("HelloWorld API")
                .description("HelloWorld API reference for developers")
                .termsOfServiceUrl("http://helloworld.com")
                .contact("smaheshwaram1@gmail.com").license("Suchi License")
                .licenseUrl("smaheshwaram1@gmail.com").version("1.0").build();
    }

}