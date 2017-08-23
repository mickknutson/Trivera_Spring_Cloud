package com.springclass.cloud;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import com.springclass.cloud.configuration.ConfigClientProperties;

@SpringBootApplication
@EnableConfigurationProperties({ ConfigClientProperties.class })
public class ConfigurationClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigurationClientApplication.class, args);
	}

	// TODO: Find out how to use debug=true property to control this:
	@Profile("trace")
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			String[] beanNames = ctx.getBeanDefinitionNames();

			System.out.println("\n********************************************");
			System.out.println("Listing the " + beanNames.length + " beans loaded by Spring Boot:");
			Arrays.stream(beanNames).sorted().forEach(System.out::println);
			System.out.println("*** the End ********************************\n");
		};
	}
} // The End
