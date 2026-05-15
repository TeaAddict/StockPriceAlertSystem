package ooo.stock.StockPriceAlertSystem.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record AlertEventResponse(
        Long id,
         BigDecimal price,
         LocalDateTime triggeredAt
) {
}
