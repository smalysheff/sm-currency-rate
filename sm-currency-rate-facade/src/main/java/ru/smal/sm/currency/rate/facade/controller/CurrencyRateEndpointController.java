package ru.smal.sm.currency.rate.facade.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.smal.sm.currency.rate.facade.model.CurrencyRate;
import ru.smal.sm.currency.rate.facade.model.RateType;
import ru.smal.sm.currency.rate.facade.service.CurrencyRateEndpointService;

import java.time.LocalDate;

@Slf4j
@RestController
@RequestMapping(path = "${app.rest.api.prefix}/v1")
@RequiredArgsConstructor
public class CurrencyRateEndpointController {

    private final CurrencyRateEndpointService service;

    @GetMapping(path = "/currency-rate/{type}/{currency}/{date}")
    public CurrencyRate getCurrencyRate(@PathVariable("type") RateType type,
                                        @PathVariable("currency") String currency,
                                        @DateTimeFormat(pattern = "dd-MM-yyyy") @PathVariable("date") LocalDate date) {

        log.info("getCurrentRate, type:{}, currency: {}, date{}", type, currency, date);

        return service.getCurrentRate(type, currency, date);
    }
}
