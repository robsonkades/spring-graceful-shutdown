package com.robsonkades.springdockerfile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

//@Component
public class GracefulShutdown implements ApplicationListener<ContextClosedEvent> {

    private static final Logger LOGGER = LoggerFactory.getLogger(GracefulShutdown.class);

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        try {
            LOGGER.info("Initialize Shutdown....");
            Thread.sleep(TimeUnit.SECONDS.toMillis(5));
            LOGGER.info("Initialize finish....");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
