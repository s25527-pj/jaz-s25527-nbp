package com.example.jazs25527nbp.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class ApiDocumentationConfig {

    @Bean
    public OpenAPI apiDocConfig() {
        return new OpenAPI()
                .info(new Info()
                        .title("ExchangeInfo API")
                        .description("Restful service for obtaining exchange info and storing it")
                        .version("0.0.1-SNAPSHOT")
                        .contact(new Contact()
                                .name("Author")
                                .email("s25527@pjwstk.edu.pl")))
                .externalDocs(new ExternalDocumentation()
                        .description("Documentation")
                        .url("https://www.youtube.com/watch?v=dQw4w9WgXcQ"));

    }
}