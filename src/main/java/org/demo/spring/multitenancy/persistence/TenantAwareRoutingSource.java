package org.demo.spring.multitenancy.persistence;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class TenantAwareRoutingSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return CurrentTenantResolver.getCurrentTenant();
    }

}
