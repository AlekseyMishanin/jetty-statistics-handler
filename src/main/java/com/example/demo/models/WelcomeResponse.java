package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

@Builder
@Jacksonized
public class WelcomeResponse {

    @JsonProperty("welcome")
    private final String welcome;
}
