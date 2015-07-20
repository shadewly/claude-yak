package com.shine.his.common.jersey;

import org.glassfish.jersey.server.ResourceConfig;

/**
 * Created by claude on 15-6-26.
 */
public class ServiceConfig extends ResourceConfig {
    public ServiceConfig() {
        //associate with spring
        register(org.glassfish.jersey.server.spring.scope.RequestContextFilter.class);

        packages("com.shine");
    }

}
