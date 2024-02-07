package com.example.springquartzwebclient.configurations.properties;

import java.time.Duration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "application-configuration.webclient")
public class WebClientProperties {
    
    private String maxResponseSize;
    private Duration timeout;

    public String getMaxResponseSize() {
        return maxResponseSize;
    }

    public WebClientProperties setMaxResponseSize(final String maxResponseSize) {
        this.maxResponseSize = maxResponseSize;
        return this;
    }

    public Duration getTimeout() {
        return timeout;
    }

    public WebClientProperties setTimeout(final Duration timeout) {
        this.timeout = timeout;
        return this;
    }

}
