package ooo.stock.StockPriceAlertSystem.dto;

import ooo.stock.StockPriceAlertSystem.model.PriceCondition;

import java.math.BigDecimal;

public record AlertRuleResponse(
        Long id,
        String ticker,
        PriceCondition priceCondition,
        BigDecimal targetPrice,
        Long userId
) {
}
