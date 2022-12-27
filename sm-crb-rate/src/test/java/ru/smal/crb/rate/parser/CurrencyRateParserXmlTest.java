package ru.smal.crb.rate.parser;

import org.junit.jupiter.api.Test;
import ru.smal.crb.rate.model.CurrencyRate;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CurrencyRateParserXmlTest {

    @Test
    public void successParse() throws URISyntaxException, IOException {
        CurrencyRateParserXml parser = new CurrencyRateParserXml();

        //given
        URI uri = ClassLoader.getSystemResource("cbr_response.xml").toURI();
        String ratesXml = Files.readString(Paths.get(uri), Charset.forName("Windows-1251"));

        //when
        List<CurrencyRate> rates = parser.parse(ratesXml);

        //then
        assertThat(rates.size()).isEqualTo(34);
        assertThat(rates.contains(getUSDrate())).isTrue();
        assertThat(rates.contains(getEURrate())).isTrue();
        assertThat(rates.contains(getJPYrate())).isTrue();
    }

    private CurrencyRate getUSDrate() {
        return CurrencyRate.builder()
                .numCode("840")
                .charCode("USD")
                .nominal("1")
                .name("Доллар США")
                .value("64,3015")
                .build();
    }

    private CurrencyRate getEURrate() {
        return CurrencyRate.builder()
                .numCode("978")
                .charCode("EUR")
                .nominal("1")
                .name("Евро")
                .value("68,4470")
                .build();
    }

    private CurrencyRate getJPYrate() {
        return CurrencyRate.builder()
                .numCode("392")
                .charCode("JPY")
                .nominal("100")
                .name("Японских иен")
                .value("47,5006")
                .build();
    }
}