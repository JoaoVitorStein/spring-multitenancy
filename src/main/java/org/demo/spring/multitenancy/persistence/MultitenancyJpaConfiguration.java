package org.demo.spring.multitenancy.persistence;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@ComponentScan
public class MultitenancyJpaConfiguration {

    @Bean
    public DataSource dataSource() {

        AbstractRoutingDataSource dataSource = new TenantAwareRoutingSource();

        Map<Object,Object> targetDataSources = new HashMap<>();

        targetDataSources.put("TenantOne", createTenant("org.postgresql.ds.PGSimpleDataSource",
                "jdbc:postgresql://127.0.0.1:5432/sampledb", "postgres", "postgres"));

        targetDataSources.put("TenantTwo", createTenant("org.postgresql.ds.PGSimpleDataSource",
                "jdbc:postgresql://127.0.0.1:5432/sampledb2", "postgres", "postgres"));

        dataSource.setTargetDataSources(targetDataSources);

        dataSource.afterPropertiesSet();

        return dataSource;
    }

    private DataSource createTenant(String dataSourceClass, String url, String user, String password) {

        HikariDataSource dataSource = new HikariDataSource();

        dataSource.setInitializationFailTimeout(0);
        dataSource.setMaximumPoolSize(5);
        dataSource.setDataSourceClassName(dataSourceClass);
        dataSource.addDataSourceProperty("url", url);
        dataSource.addDataSourceProperty("user", user);
        dataSource.addDataSourceProperty("password", password);

        return dataSource;
    }


}
