package ru.advantum.kotin.featureflags.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Around;

@Aspect
@Component
@Slf4j
public class FeaturesAspect {



    @Around(value = "@within(featureAssociation) || @annotation(featureAssociation)")
    public Object checkAspect(ProceedingJoinPoint joinPoint, FeatureAssociation featureAssociation) throws Throwable {
        if (featureAssociation.value().isActive()) {
            return joinPoint.proceed();
        } else {
            log.warn("Feature {} is not enabled!", featureAssociation.value().name());
            return null;
        }
    }
}