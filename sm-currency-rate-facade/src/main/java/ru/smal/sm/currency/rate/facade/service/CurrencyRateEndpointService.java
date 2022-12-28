package ru.smal.sm.currency.rate.facade.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.smal.sm.currency.rate.facade.client.RateClient;
import ru.smal.sm.currency.rate.facade.model.CurrencyRate;
import ru.smal.sm.currency.rate.facade.model.RateType;

import java.time.LocalDate;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class CurrencyRateEndpointService {

    private final Map<String, RateClient> clients;

    public CurrencyRate getCurrentRate(RateType type, String currency, LocalDate date) {
        log.info("getCurrencyRate, ratyType: {}, currency: {}, date: {}", type, currency, date);
        RateClient client = clients.get(type.getServiceName());
        return client.getCurrencyRate(currency, date);
    }
}
