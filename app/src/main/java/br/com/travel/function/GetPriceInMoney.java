package br.com.travel.function;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public interface GetPriceInMoney {

    static String execute(BigDecimal price) {
        return DecimalFormat.getCurrencyInstance().format(price);
    }
}
