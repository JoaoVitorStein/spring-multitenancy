package org.demo.spring.multitenancy;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class MultitenancyApplication  extends SpringBootServletInitializer {

    public static void main(String[] args) {
        new MultitenancyApplication()
                .configure(new SpringApplicationBuilder(MultitenancyConfiguration.class))
                .run(args);
    }

}
