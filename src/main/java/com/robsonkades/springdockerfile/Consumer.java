package com.robsonkades.springdockerfile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

@Component
public class Consumer implements  SmartLifecycle {

    private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

    public boolean isRunning;

    @Override
    public void start() {
        this.isRunning = true;
        LOGGER.info("Running start {}", true);
    }

    @Override
    public void stop() {
        this.isRunning = false;
        LOGGER.info("Running stop {}", false);
    }

    @Override
    public boolean isRunning() {
        LOGGER.info("Running isRunning {}", isRunning);
        return this.isRunning;
    }
}
