package com.example.springquartzwebclient.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import com.example.springquartzwebclient.client.api.BookerApiClient;

@Configuration
public class ClientApiConfiguration {
    
    @Bean
    BookerApiClient bookerApiClient(final HttpServiceProxyFactory httpServiceProxyFactory) {

        return httpServiceProxyFactory.createClient(BookerApiClient.class);
    }

}
