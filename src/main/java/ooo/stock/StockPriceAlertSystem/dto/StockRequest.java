package ooo.stock.StockPriceAlertSystem.dto;

import java.math.BigDecimal;

public record StockRequest(
        String name,
        BigDecimal price
) {
}
