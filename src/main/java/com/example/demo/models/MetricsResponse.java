package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

@Builder
@Jacksonized
public class MetricsResponse {

    @JsonProperty("responses_1xx")
    private final int responses1xx;

    @JsonProperty("responses_2xx")
    private final int responses2xx;

    @JsonProperty("responses_3xx")
    private final int responses3xx;

    @JsonProperty("responses_4xx")
    private final int responses4xx;

    @JsonProperty("responses_5xx")
    private final int responses5xx;
}
