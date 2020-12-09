package com.sugarfactory.nirabhima1.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Configuration
/*@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "nirabhima1EntityManagerFactory",
        transactionManagerRef = "nirabhima1TransactionManager"
)*/
public class Nirabhima1DBConfig {
/*
    // Datasource method goes here
    @Primary
    @Bean(name="datasource")
    @ConfigurationProperties(prefix = "spring.nirabhima1.datasource")
    public DataSource dataSource(){
        return DataSourceBuilder.create().build();
    }

    // LocalContainerEntityManagerFactoryBean goes here
    @Primary
    @Bean(name="nirabhima1TransactionManager")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(
            EntityManagerFactoryBuilder builder,
            @Qualifier("datasource") DataSource dataSource
    )
    {
        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "update");
        //properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialects");
        return builder
                .dataSource(dataSource)
                .properties(properties)
                .packages("com.sugarfactory.nirabhima1.model")
                .persistenceUnit("DistanceInfo")
                .build();
    }

    // PlatformTransactionManager goes here
    @Primary
    @Bean(name="nirabhima1TransactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory
    )
    {
        return new JpaTransactionManager(entityManagerFactory);
    }*/
}