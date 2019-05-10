package com.daoliuhe.monitor.config;


import com.daoliuhe.monitor.properties.MonitorProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * The class Aliyun core config.
 *
 * @author paascloud.net @gmail.com
 */
@Configuration
@EnableConfigurationProperties(MonitorProperties.class)
public class MonitorCoreConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
