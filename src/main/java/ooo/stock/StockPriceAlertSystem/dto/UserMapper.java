package ooo.stock.StockPriceAlertSystem.dto;

import ooo.stock.StockPriceAlertSystem.model.User;

public class UserMapper {
    public static UserResponse toUserResponse(User user){
        return new UserResponse(user.getId(), user.getUserName());
    }
}
