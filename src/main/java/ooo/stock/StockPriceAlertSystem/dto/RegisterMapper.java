package ooo.stock.StockPriceAlertSystem.dto;

import ooo.stock.StockPriceAlertSystem.model.User;

public class RegisterMapper {

    public static User toUser(RegisterRequest registerRequest){
        User user = new User();
        user.setUserName(registerRequest.userName());
        user.setEmail(registerRequest.email());
        user.setPassword(registerRequest.password());
        return user;
    }
}
