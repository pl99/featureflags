package ru.advantum.kotin.featureflags.rest.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("AV")
public class Av02TariffService implements TariffService {
    @Override
    public String calcTariff() {
        return "AV02";
    }
}
