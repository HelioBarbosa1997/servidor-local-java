package com.labanta.servidorlocal.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition (
        info = @Info(
                title = "Servidor Local Java Docs",
                version = "v1.0",
                description = "Documentacao da nossa api em Java Spring Boot"
        )

)
@SecurityScheme(
        name = "BearerAuth",
        type = SecuritySchemeType.HTTP,
        scheme = "bearer",
        bearerFormat = "JWT"
)
public class SwaggerConfig {
    // Pode ser vazio, e o swagger panha td @RestController,
    //@PostMapping, @GetMapping automaticamente.
}
