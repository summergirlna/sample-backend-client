package com.example.backendclient.config;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;

@AutoConfiguration
@EnableConfigurationProperties(BackendClientProperties.class)
public class BackendClientAutoConfiguration {

  @Bean
  @ConditionalOnMissingBean(name = "backendRestClient")
  public RestClient backendRestClient(
      RestClient.Builder builder, BackendClientProperties backendClientProperties) {
    return builder.baseUrl(backendClientProperties.baseUrl()).build();
  }
}
