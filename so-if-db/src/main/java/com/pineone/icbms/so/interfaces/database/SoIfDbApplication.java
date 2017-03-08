package com.pineone.icbms.so.interfaces.database;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.pineone.icbms.so")
@EntityScan(basePackages = "com.pineone.icbms.so")
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "com.pineone.icbms.so")
public class SoIfDbApplication {

    /**
     * run application.<BR/>
     * @param args arguments
     */
    public static void main(String[] args) {
		SpringApplication.run(SoIfDbApplication.class, args);
    }
}
