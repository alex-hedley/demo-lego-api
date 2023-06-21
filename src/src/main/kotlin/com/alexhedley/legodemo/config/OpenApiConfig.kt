package com.alexhedley.legodemo.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Contact
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.License
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OpenApiConfig {

    @Bean
    fun legoOpenAPI(): OpenAPI {
        return OpenAPI()
                .info(Info()
                    .title("Lego API")
                    .description("Brick Collection")
                    .version("1.0")
                    .contact(Contact().name("Alex Hedley").email("alex.hedley@opencastsoftware.com"))
                    .license(License().name("MIT").url("https://opensource.org/licenses/MIT"))
                    //.termsOfService("")
            );
    }
}