package com.mitocode;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//si se necesita indicar que la clase va a tener configuraciones de beans se necesita marcar 
//como @Configuration

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	//url de la pagina donde puede acceder el front-end a ver la documentación
	//http://localhost:8080/swagger-ui.html#/paciente-controller/listarUsingGET
	
	public static final Contact DEFAULT_CONTACT = new Contact("Bit Data Solution","http://www.bitdatasolution.com",
			"contacto@bds.com");
	public static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Mediapp Api Documentation", "Medi app Api Documentation","1.0",
			"PREMIUN", DEFAULT_CONTACT, "Apache 2.0","http://www.apache.org/licenses/LICENCE-2.0",
			new ArrayList<VendorExtension>());
	

	//creamos un bean como instancia en el core container
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT_API_INFO);
	}
}
