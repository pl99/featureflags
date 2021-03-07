package ru.advantum.kotin.featureflags.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.togglz.core.manager.EnumBasedFeatureProvider;
import org.togglz.core.spi.FeatureProvider;

@Configuration
@EnableJpaRepositories("ru.advantum.kotin.featureflags.dao")
@EntityScan("ru.advantum.kotin.featureflags.dao")
public class ToggleConfiguration {

    @Bean
    public FeatureProvider featureProvider() {
        return new EnumBasedFeatureProvider(MyFeatures.class);
    }
}