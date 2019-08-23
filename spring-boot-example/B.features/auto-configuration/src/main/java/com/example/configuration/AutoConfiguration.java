package com.example.configuration;

import com.example.properties.WrapServiceProperties;
import com.example.service.WrapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(WrapService.class)
@EnableConfigurationProperties(WrapServiceProperties.class)
public class AutoConfiguration {

    @Autowired
    private WrapServiceProperties properties;

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "wrap", value = "enabled", havingValue = "true")
    WrapService wrapService() {
        return new WrapService(properties.getPrefix(), properties.getSuffix());
    }

}
