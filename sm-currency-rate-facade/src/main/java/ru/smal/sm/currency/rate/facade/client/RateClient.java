package ru.smal.sm.currency.rate.facade.client;

import ru.smal.sm.currency.rate.facade.model.CurrencyRate;

import java.time.LocalDate;

public interface RateClient {
    CurrencyRate getCurrencyRate(String currency, LocalDate date);
}
