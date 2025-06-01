package org.server.config;

import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.server.controller.ProductController;
// For adding a base path
@ApplicationPath("/api/v1")
public class AppResourceConfig extends ResourceConfig {

    public AppResourceConfig() {
        register(ProductController.class);
        register(ApplicationBinder.class);
    }
}
