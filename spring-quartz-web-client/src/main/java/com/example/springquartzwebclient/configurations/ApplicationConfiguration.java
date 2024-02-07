package com.example.springquartzwebclient.configurations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.util.unit.DataSize;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import com.example.springquartzwebclient.configurations.properties.WebClientProperties;

import reactor.netty.http.client.HttpClient;

@Configuration
public class ApplicationConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationConfiguration.class);

    private final WebClientProperties webClientProperties;

    public ApplicationConfiguration(final WebClientProperties webClientProperties) {
        this.webClientProperties = webClientProperties;
    }
    
    @Bean
    WebClient webClient() {

        final long maxResponseSizeBytes = DataSize.parse(this.webClientProperties.getMaxResponseSize())
                .toBytes();
        final int convertedMaxResponseSize;

        if (maxResponseSizeBytes > Integer.MAX_VALUE) {
            LOGGER.warn("Configuration for max response size is not applicable. Setting max int value {}", Integer.MAX_VALUE);
            convertedMaxResponseSize = Integer.MAX_VALUE;
        } else {
            convertedMaxResponseSize = (int) maxResponseSizeBytes;
        }

        final HttpClient httpClient = HttpClient.create()
            .responseTimeout(this.webClientProperties.getTimeout());

        return WebClient.builder()
            .clientConnector(new ReactorClientHttpConnector(httpClient))
            .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(convertedMaxResponseSize))
            .build();
    }

    @Bean
    HttpServiceProxyFactory httpServiceProxyFactory(final WebClient webClient) {
        return HttpServiceProxyFactory.builderFor(WebClientAdapter.create(webClient))
            .build();
    }

}
