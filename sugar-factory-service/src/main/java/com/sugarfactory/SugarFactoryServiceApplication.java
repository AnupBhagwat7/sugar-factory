package com.sugarfactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class,
		org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
		})
@ComponentScan("com.sugarfactory.*")
public class SugarFactoryServiceApplication {

	public static void main(String[] args)	 {
		SpringApplication.run(SugarFactoryServiceApplication.class, args);
	}

}
