package com.rxf113.p6spy;

import com.p6spy.engine.spy.P6SpyDriver;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


/**
 * @author rxf113
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnClass(P6SpyDriver.class)
@EnableConfigurationProperties(P6spyProperties.class)
@ConditionalOnBean(DataSource.class)
@AutoConfigureAfter(value = DataSourceAutoConfiguration.class)
@ConditionalOnProperty(prefix = Constants.P6SPY_CONFIG_PREFIX, name = "enabled", havingValue = "true", matchIfMissing = true)
public class P6spyAutoConfiguration {

    private P6spyAutoConfiguration() {
    }

    @Bean
    public static CusP6spyConfigLoaderBeanPostProcessor cusP6spyConfigLoaderBeanPostProcessor() {
        return new CusP6spyConfigLoaderBeanPostProcessor();
    }
}

