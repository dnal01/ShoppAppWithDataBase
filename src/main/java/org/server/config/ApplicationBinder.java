package org.server.config;

import jakarta.ws.rs.core.Feature;
import jakarta.ws.rs.core.FeatureContext;
import org.example.app.repository.user.UserRepository;
import org.example.app.repository.user.UserRepositoryImpl;
import org.example.app.service.user.UserService;
import org.example.app.service.user.UserServiceImpl;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.jackson.internal.jackson.jaxrs.json.JacksonJsonProvider;


public class ApplicationBinder implements Feature {

    /**
     * Метод реєструє нижчеприведені класи в контексті контейнера, який буде
     * за автоматично керувати залежностями (dependency injection).
     */
    @Override
    public boolean configure(FeatureContext context) {
        context.register(new AbstractBinder() {
            @Override
            protected void configure() {
                bind(UserRepositoryImpl.class).to(UserRepository.class);
                bind(UserServiceImpl.class).to(UserService.class);
                // Цей клас потрібен для роботи із JSON форматом даних
                bind(JacksonJsonProvider.class);
            }
        });
        return true;
    }
}
