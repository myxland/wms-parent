package com.deer.wms.finance.configurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Swagger 配置文件
 *
 * Created by Floki on 2017/8/10.
 */
//@Configuration
//@EnableSwagger2
public class FinanceSwaggerConfigurer {
    /**
     * 创建API基本信息
     *
     * @return
     */
    //@Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("财务信息")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.deer.finance"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {// 创建API的基本信息，这些信息会在Swagger UI中进行显示
        return new ApiInfoBuilder()
                .title("使用 Swagger2 构建的 RestFul APIs")// API 标题
                .description("供应管理服务提供的 RestFul APIs")// API描述
                .contact(new Contact("guojingxun", "", "1466181575@qq.com")) //联系人
                .version("1.0")// 版本号
                .build();
    }
}
