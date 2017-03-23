package com.pineone.icbms.so.web;

import com.pineone.icbms.so.web.spring.CustomBeanNameGenerator;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.pineone.icbms.so")
@EntityScan(basePackages = "com.pineone.icbms.so")
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "com.pineone.icbms.so")
public class SoWebApplication /* extends SpringBootServletInitializer //for external tomcat binding */ {

    /**
     * for external tomcat binding.<BR/>
     *
     * @param builder SpringApplicationBuilder
     * @return SpringApplicationBuilder
     */
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        return builder.sources(SoWebApplication.class);
//    }

    /**
     * run application.<BR/>
     *
     * @param args arguments
     */
    public static void main(String[] args) {
        System.out.println("user.dir: " + System.getProperty("user.dir"));
//		SpringApplication.run(SoProcessorApplication.class, args);
        CustomBeanNameGenerator beanNameGenerator = new CustomBeanNameGenerator();
        new SpringApplicationBuilder(SoWebApplication.class)
                .beanNameGenerator(beanNameGenerator)
                .run(args);
    }
}
