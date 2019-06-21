package org.demo.spring.multitenancy.persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CurrentTenantResolver {

    private static Logger logger = LoggerFactory.getLogger(CurrentTenantResolver.class);
    private static ThreadLocal<String> currentTenant = new ThreadLocal<>();

    public static void setCurrentTenant(String tenant) {
        logger.debug("Setting tenant to " + tenant);
        currentTenant.set(tenant);
    }

    public static String getCurrentTenant() {
        return currentTenant.get();
    }

    public static void clear() {
        currentTenant.set(null);
    }

}
