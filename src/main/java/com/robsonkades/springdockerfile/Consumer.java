package com.robsonkades.springdockerfile;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.SmartLifecycle;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class Consumer implements  ServletContextListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

    public boolean isRunning;
//
//    @Override
//    public void start() {
//        this.isRunning = true;
//        LOGGER.info("Running start {}", true);
//    }
//
//    @Override
//    public void stop() {
//        this.isRunning = false;
//        LOGGER.info("Running stop {}", false);
//    }
//
//    @Override
//    public boolean isRunning() {
//        LOGGER.info("Running isRunning {}", isRunning);
//        return this.isRunning;
//    }
//
//    @Override
//    public void onApplicationEvent(ContextClosedEvent event) {
//        LOGGER.info("onApplicationEvent {}", isRunning);
//        this.isRunning = false;
//    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        this.isRunning = true;
        LOGGER.info("contextInitialized {}", true);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        LOGGER.info("Inicializando desligamento consumer");
        this.isRunning = false;
        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(20));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        LOGGER.info("Desligamento completo consumer");
    }
}
