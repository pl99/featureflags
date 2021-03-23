package ru.advantum.kotin.featureflags.rest;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.advantum.kotin.featureflags.rest.services.TariffService;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("data")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class FeatureController {

    List<TariffService> services;

    @PostMapping("tariff")
    public String doSomethingg() {
        String collect = services.stream()
                .limit(1)
                .map(TariffService::calcTariff)
                .collect(Collectors.joining())
                ;
        return collect;
    }
}
