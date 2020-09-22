package br.com.infnet.appemprestimo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
		.select()
		.apis(RequestHandlerSelectors.basePackage("br.com.infnet.appescola.controller"))
		.paths(PathSelectors.any())
		.build()
		.useDefaultResponseMessages(false)
		.apiInfo(apiInfo())
		.globalResponseMessage(RequestMethod.GET, responseMessages());
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("AppEscola")
				.description("Sistema para gestão escolar")
				.version("1.0.0")
				.contact(new Contact("Elberth Moraes", "infnet.edu.br", "elberth.moraes@prof.infnet.edu.br"))
				.build();
	}
	
	@SuppressWarnings("serial")
	private List<ResponseMessage> responseMessages(){
		return new ArrayList<ResponseMessage>() {{
			add(new ResponseMessageBuilder()
			.code(403)
			.message("Forbidden!")
			.build());
			}};
	}
}