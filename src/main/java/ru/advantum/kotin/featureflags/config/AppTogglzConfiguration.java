package ru.advantum.kotin.featureflags.config;

import lombok.SneakyThrows;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.filter.AssignableTypeFilter;
import org.togglz.core.Feature;
import org.togglz.core.manager.EnumBasedFeatureProvider;
import org.togglz.core.manager.TogglzConfig;
import org.togglz.core.repository.StateRepository;
import org.togglz.core.spi.FeatureProvider;
import org.togglz.core.user.FeatureUser;
import org.togglz.core.user.SimpleFeatureUser;
import org.togglz.core.user.UserProvider;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppTogglzConfiguration implements TogglzConfig {
    @Override
    public Class<? extends Feature> getFeatureClass() {
        return TariffFeatures.class;
    }

    @Override
    public StateRepository getStateRepository() {
        return null;
    }

    @Override
    public UserProvider getUserProvider() {
        return new UserProvider() {
            @Override
            public FeatureUser getCurrentUser() {
                return new SimpleFeatureUser("admin", true);
            }
        };
    }

    @Bean
    public FeatureProvider tariffFeatureProvider() {
        List<Class<Feature>> features = scanAndFill();

        EnumBasedFeatureProvider enumBasedFeatureProvider = new EnumBasedFeatureProvider();
        features.forEach(enumBasedFeatureProvider::addFeatureEnum);
        return enumBasedFeatureProvider;
    }

    //    @PostConstruct
    @SneakyThrows
    @SuppressWarnings("unchecked")
    public List<Class<Feature>> scanAndFill() {
        List<Class<Feature>> features = new ArrayList<>();
        ClassPathScanningCandidateComponentProvider scanner =
                new ClassPathScanningCandidateComponentProvider(false);
        scanner.addIncludeFilter(new AssignableTypeFilter(Feature.class));
//        scanner.addIncludeFilter(new AnnotationTypeFilter(TranslatableEnumAnnotation.class));
        for (BeanDefinition beanDefinition : scanner
                .findCandidateComponents(ru.advantum.kotin.featureflags.config.FeatureAssociation.class.getPackageName())) {
            features.add((Class<Feature>) Class.forName(beanDefinition.getBeanClassName()));
        }
        return features;
    }
}
