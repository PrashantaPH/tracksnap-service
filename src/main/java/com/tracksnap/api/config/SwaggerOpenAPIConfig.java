package com.tracksnap.api.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
		info = @Info(
				  title = "Tracksnap API",
				  description = "Tracksnap service",
				  summary = "Tracksnap service will help store it in a database",
				  termsOfService = "https://tracksnap.com",
				  contact = @Contact(
								name = "Prashanta",
								email = "tracksnapservice@gmail.com"
						),
				  license = @License(
								name = "No License"
						),
				  version = "V1"
				),
		servers = {
			@Server(
				description = "DEV",
				url = "http://localhost:8080/api/v1/companies"
			),
			@Server(
				description = "SIT",
				url = "http://localhost:8080/api/v1/companies"
			)
		}
)
public class SwaggerOpenAPIConfig {

}
