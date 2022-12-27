package ru.smal.crb.rate.parser;

import ru.smal.crb.rate.model.CurrencyRate;

import java.util.List;

/**
 * @author Sergey Malyshev
 * @version 1.0
 */
public interface CurrencyRateParser {

    List<CurrencyRate> parse(String ratesAsString);
}
