package ooo.stock.StockPriceAlertSystem.dto;

import ooo.stock.StockPriceAlertSystem.model.Role;

public record UserResponse(
        Long id,
        String userName,
        String email,
        Role role
) {
}
