package com.sugarfactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = {//DataSourceAutoConfiguration.class,
		org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
		})
//@EnableJpaRepositories(basePackages="com.sugarfactory.repository", entityManagerFactoryRef="emf")
@ComponentScan(basePackages = {"com.sugarfactory"})
@EntityScan("com.sugarfactory.model")
public class SugarFactoryServiceApplication {

	public static void main(String[] args)	 {
		SpringApplication.run(SugarFactoryServiceApplication.class, args);
	}

}
