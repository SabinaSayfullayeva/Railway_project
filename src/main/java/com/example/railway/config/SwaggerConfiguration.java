package com.example.railway.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//it is may class
@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Railway application",
                description = "This application  very comfortable for you",
                version = "1.1.1",
                contact = @Contact(
                        name = "Sabina Sayfullayeva",
                        url = "http/**"

                ),
                license = @License(
                        name = "Apache 3.0",
                        url = "http/**"
                ),
                termsOfService = "http/**",
                summary = "The project is fully supported by me"
        ),
        servers ={ @Server(
                url = "http//localhost:8081/swagger",
                description = "Development server"

        )}
)
public class SwaggerConfiguration {
    @Bean
    SecurityScheme securityScheme()
    {
        return new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("Bearer").bearerFormat("JWT");
    }
    @Bean
    OpenAPI openAPI()
    {
        return new OpenAPI().addSecurityItem(new SecurityRequirement()
                .addList("JWT authentication")).components(new Components().addSecuritySchemes("bearer auth",new SecurityScheme()
                .name("bearer auth").type(SecurityScheme.Type.HTTP).bearerFormat("Bearer").in(SecurityScheme.In.HEADER).scheme("Bearer")));
    }
}
