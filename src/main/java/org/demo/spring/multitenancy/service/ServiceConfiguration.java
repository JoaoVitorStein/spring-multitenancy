package org.demo.spring.multitenancy.service;

import org.demo.spring.multitenancy.cache.MultitenancyCacheConfiguration;
import org.demo.spring.multitenancy.persistence.MultitenancyJpaConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan
@Import({MultitenancyJpaConfiguration.class, MultitenancyCacheConfiguration.class})
public class ServiceConfiguration {
}
