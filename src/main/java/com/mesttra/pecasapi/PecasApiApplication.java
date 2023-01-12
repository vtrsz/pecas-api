package com.mesttra.pecasapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Pecas API", version = "1.1", description = "Uma API de pecas"))
public class PecasApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PecasApiApplication.class, args);
	}

}