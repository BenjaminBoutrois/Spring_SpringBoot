package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@ComponentScan(basePackages = {"com.example.controllers"})
@EnableJpaRepositories(basePackages = {"com.example.repositories"})
@EntityScan(basePackages = {"com.example.entities"})
public class DemoJpaWebApplication
{
	@RequestMapping("/")
	String home()
	{
		return "Bienvenue sur l'application";
	}

	public static void main(String[] args)
	{
		SpringApplication.run(DemoJpaWebApplication.class, args);
	}

}
