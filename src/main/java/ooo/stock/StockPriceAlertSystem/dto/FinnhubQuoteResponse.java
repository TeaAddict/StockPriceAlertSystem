package ooo.stock.StockPriceAlertSystem.dto;

import java.math.BigDecimal;

public record FinnhubQuoteResponse(
        BigDecimal c
) {
}
