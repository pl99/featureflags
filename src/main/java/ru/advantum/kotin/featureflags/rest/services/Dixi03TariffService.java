package ru.advantum.kotin.featureflags.rest.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dixi")
public class Dixi03TariffService implements TariffService {
    @Override
    public String calcTariff() {
        return "dixi03";
    }
}
