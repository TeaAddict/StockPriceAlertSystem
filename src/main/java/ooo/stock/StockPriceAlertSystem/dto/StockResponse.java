package ooo.stock.StockPriceAlertSystem.dto;

import java.math.BigDecimal;

public record StockResponse(
        Long id,
        String name,
        BigDecimal price
) {
}
