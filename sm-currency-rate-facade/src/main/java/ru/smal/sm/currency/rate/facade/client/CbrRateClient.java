package ru.smal.sm.currency.rate.facade.client;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.smal.sm.currency.rate.facade.configuration.CbrRateClientConfig;
import ru.smal.sm.currency.rate.facade.model.CurrencyRate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Slf4j
@Service("cbr")
@RequiredArgsConstructor
public class CbrRateClient implements RateClient {

    private final static String DATE_FORMAT = "dd-MM-yyyy";
    private final static DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_FORMAT);

    private final RestTemplate restTemplate;
    private final CbrRateClientConfig config;

    @Override
    public CurrencyRate getCurrencyRate(String currency, LocalDate date) {
        String url = String.format("%s/%s/%s", config.getUrl(), currency, DATE_FORMATTER.format(date));
        log.info("Сформирован url: {}", url);

        CurrencyRate response = restTemplate.getForObject(url, CurrencyRate.class);
        log.info("Получен ответ от sm-cbr-rate: {}", response);

        return response;
    }
}
