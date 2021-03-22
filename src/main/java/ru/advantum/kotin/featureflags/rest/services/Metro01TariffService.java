package ru.advantum.kotin.featureflags.rest.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("metro")
public class Metro01TariffService implements TariffService {
    @Override
    public String calcTariff() {
        return "Metro01";
    }
}
