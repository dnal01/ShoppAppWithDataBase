package org.server.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.server.entities.Product;
import org.server.entities.Variant;
import org.server.utils.ErrorMessage;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.io.IOException;
import java.util.Properties;

public class HibernateConfig {

    private static final Logger LOGGER =
            LogManager.getLogger(HibernateConfig.class.getName());

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = getConfiguration();
                configuration.addAnnotatedClass(Product.class);
                configuration.addAnnotatedClass(Variant.class);
                ServiceRegistry serviceRegistry =
                        new StandardServiceRegistryBuilder()
                                .applySettings(configuration.getProperties()).build();
                sessionFactory = configuration
                        .buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                LOGGER.error(ErrorMessage.LOG_DB_ERROR_MSG.getMessage());
            }
        }
        return sessionFactory;
    }

    private static Configuration getConfiguration() {
        Configuration configuration = new Configuration();
        Properties props = new Properties();
        try {
            props.load(HibernateConfig.class.getClassLoader().getResourceAsStream("db/jdbc.properties"));
            props.put(Environment.JAKARTA_JDBC_DRIVER, props.getProperty("dbDriver"));
            props.put(Environment.JAKARTA_JDBC_URL, props.getProperty("dbUrl"));
            props.put(Environment.JAKARTA_JDBC_USER, props.getProperty("dbUser"));
            props.put(Environment.JAKARTA_JDBC_PASSWORD, props.getProperty("dbPass"));
            props.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
            configuration.setProperties(props);
            return configuration;
        } catch (IOException e) {
            LOGGER.error(ErrorMessage.LOG_DB_ERROR_MSG.getMessage());
            throw new RuntimeException(e);
        }
    }
}
