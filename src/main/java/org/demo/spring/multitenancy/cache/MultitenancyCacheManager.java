package org.demo.spring.multitenancy.cache;

import org.demo.spring.multitenancy.persistence.CurrentTenantResolver;
import org.springframework.cache.Cache;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.AbstractCacheManager;

import java.util.Collection;
import java.util.Collections;

public class MultitenancyCacheManager extends AbstractCacheManager {

    private final Collection<? extends Cache> caches = Collections.emptySet();

    @Override
    protected Collection<? extends Cache> loadCaches() {
        return this.caches;
    }

    @Override
    protected Cache getMissingCache(String name) {
        return new ConcurrentMapCache(name, true);
    }

    @Override
    public Cache getCache(final String cacheName) {
        if (CurrentTenantResolver.getCurrentTenant() == null) {
            throw new IllegalArgumentException("Cache manager couldn't get cache. Current tenant is null");
        } else {
            return super.getCache(cacheName);
        }
    }
}
