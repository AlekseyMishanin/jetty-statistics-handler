package com.example.demo.controllers;

import com.example.demo.models.MetricsResponse;
import com.example.demo.models.WelcomeResponse;
import org.eclipse.jetty.server.handler.StatisticsHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.demo.controllers.Urls.*;

@RestController
public class AppController {

    @Autowired
    private StatisticsHandler statisticsHandler;

    @GetMapping(OK)
    public WelcomeResponse ok() {
        return WelcomeResponse.builder()
                .welcome("You are welcome")
                .build();
    }

    @GetMapping(BAD)
    public ResponseEntity<?> bad() {
        return ResponseEntity.badRequest().build();
    }

    @GetMapping(ERROR)
    public void error() {
        throw new IllegalArgumentException("Internal server error");
    }

    @GetMapping(METRICS)
    public MetricsResponse metrics() {
        return MetricsResponse.builder()
                .responses1xx(statisticsHandler.getResponses1xx())
                .responses2xx(statisticsHandler.getResponses2xx())
                .responses3xx(statisticsHandler.getResponses3xx())
                .responses4xx(statisticsHandler.getResponses4xx())
                .responses5xx(statisticsHandler.getResponses5xx())
                .build();
    }
}