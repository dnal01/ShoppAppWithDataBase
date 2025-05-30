package org.server.config;

import jakarta.ws.rs.ApplicationPath;
import org.controller.UserController;
import org.glassfish.jersey.server.ResourceConfig;

// @ApplicationPath описує кореневий шлях,
// який буде використовуватися у всіх наявних
// веб-сервісах (фронт-контроллерах)
@ApplicationPath("/api/v1")
public class AppResourceConfig extends ResourceConfig {

    public AppResourceConfig() {
        // Реєстрація UserController
        // для подальшої його ініціалізації (створення)
        register(UserController.class);
        // Реєстрація конфігураційного класу
        // і наявних в ньому класів
        register(ApplicationBinder.class);
    }
}
