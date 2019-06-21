package org.demo.spring.multitenancy;

import org.demo.spring.multitenancy.restApi.RestApiConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({RestApiConfiguration.class})
@ComponentScan
public class MultitenancyConfiguration {
}
