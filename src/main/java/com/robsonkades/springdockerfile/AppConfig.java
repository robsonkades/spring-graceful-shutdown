package com.robsonkades.springdockerfile;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class AppConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppConfig.class);

    @Bean
    ServletListenerRegistrationBean<ServletContextListener> servletListener() {
        ServletListenerRegistrationBean<ServletContextListener> srb = new ServletListenerRegistrationBean<>();
        srb.setListener(new AwaitServlet());
        return srb;
    }

    public static class AwaitServlet implements ServletContextListener {

        @Override
        public void contextDestroyed(ServletContextEvent sce) {
            LOGGER.info("Inicializando desligamento consumer");
            try {
                Thread.sleep(TimeUnit.SECONDS.toMillis(20));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            LOGGER.info("Desligamento completo consumer");
        }
    }
}
