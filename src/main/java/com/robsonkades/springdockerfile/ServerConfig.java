package com.robsonkades.springdockerfile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.embedded.tomcat.ConfigurableTomcatWebServerFactory;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//@Configuration
//public class ServerConfig implements WebServerFactoryCustomizer<ConfigurableTomcatWebServerFactory> {

 //   @Autowired
//    private GracefulShutdown gracefulShutdown;
//
//    @Override
//    public void customize(ConfigurableTomcatWebServerFactory factory) {
//        factory.addConnectorCustomizers(gracefulShutdown);
//    }
//}
