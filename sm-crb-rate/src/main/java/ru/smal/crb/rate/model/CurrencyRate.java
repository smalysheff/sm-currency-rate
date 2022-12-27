package ru.smal.crb.rate.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

/**
 * Модель для внешнего API, содержит сведения о курсе вылюты
 */

@Value
@AllArgsConstructor(onConstructor = __@JsonCreator)
@Builder
public class CurrencyRate {

    String numCode;
}
