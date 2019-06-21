package org.demo.spring.multitenancy.cache;

import org.demo.spring.multitenancy.persistence.CurrentTenantResolver;
import org.springframework.cache.CacheManager;
import org.springframework.cache.interceptor.CacheOperationInvocationContext;
import org.springframework.cache.interceptor.SimpleCacheResolver;

import java.util.Collection;
import java.util.Collections;

public class MultitenancyCacheResolver extends SimpleCacheResolver {


    public MultitenancyCacheResolver(CacheManager cacheManager){
        super(cacheManager);
    }

    @Override
    protected Collection<String> getCacheNames(CacheOperationInvocationContext<?> context) {
        final String currentTenant = CurrentTenantResolver.getCurrentTenant();
        final Collection<String> unresolvedCacheNames = super.getCacheNames(context);
        assert unresolvedCacheNames != null;
        return Collections.singletonList(currentTenant + "." + unresolvedCacheNames.iterator().next());
    }
}
