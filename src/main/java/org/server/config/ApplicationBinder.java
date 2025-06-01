package org.server.config;

import jakarta.ws.rs.core.Feature;
import jakarta.ws.rs.core.FeatureContext;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.jackson.internal.jackson.jaxrs.json.JacksonJsonProvider;
import org.server.repository.product.ProductRepository;
import org.server.services.product.ProductService;
import org.server.repository.product.ProductRepositoryImp;
import org.server.services.product.ProductServiceImp;

// For injections
public class ApplicationBinder implements Feature {
    @Override
    public boolean configure(FeatureContext context) {
        context.register(new AbstractBinder() {
            @Override
            protected void configure() {
                bind(ProductRepositoryImp.class).to(ProductRepository.class);
                bind(ProductServiceImp.class).to(ProductService.class);
                bind(JacksonJsonProvider.class);
            }
        });
        return true;
    }
}
