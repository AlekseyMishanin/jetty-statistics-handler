package com.example.demo.configuration;

import org.eclipse.jetty.server.handler.StatisticsHandler;
import org.springframework.boot.web.embedded.jetty.JettyServerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public JettyServerCustomizer jettyServerCustomizer() {
        return server -> {
            StatisticsHandler handler = statisticsHandler();
            handler.setHandler(server.getHandler());
            server.setHandler(handler);
        };
    }

    @Bean
    public StatisticsHandler statisticsHandler() {
        return new StatisticsHandler();
    }
}
