package com.pywl.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger2的配置文件
 *
 * @author DP
 * @ConditionalOnProperty 用来控制Configuration是否生效
 * 是否开启swagger，正式环境一般是需要关闭的（避免不必要的漏洞暴露！），可根据springboot的多环境配置进行设置
 */
@Configuration
@EnableSwagger2
@ConditionalOnProperty(name = "swagger.enable", havingValue = "true")
public class SwaggerConfig {
	/**
	 * 创建API。
	 * 这里可以配置swagger2的一些基本的内容，比如扫描的包等等
	 *
	 * @return
	 */
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
			.pathMapping("/")
			// api文档的详细信息函数。用来创建该API的基本信息，展示在文档的页面中（自定义展示的信息）
			.apiInfo(apiInfo())
			// 设置哪些接口暴露给Swagger展示
			.select()
			// 扫描所有有注解的api，用这种方式更灵活
			// .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
			// 扫描指定包中的swagger注解，本次选用这种
			.apis(RequestHandlerSelectors.basePackage("com.pywl.controller"))
			// 扫描所有
			// .apis(RequestHandlerSelectors.any())
			.paths(PathSelectors.any())
			.build();
	}

	/**
	 * 摘要信息
	 *
	 * @return
	 */
	private ApiInfo apiInfo() {
		// 用ApiInfoBuilder进行定制
		return new ApiInfoBuilder()
			// 设置标题
			.title("标题：springboot整合swagger2项目_接口文档")
			// 描述
			.description("描述：整合项目接口信息，用于总结学习")
			// 作者信息
			.contact(new Contact("pywl", null, null))
			// 版本
			.version("版本号:" + "1.0-SNAPSHOT")
			.build();
	}
}