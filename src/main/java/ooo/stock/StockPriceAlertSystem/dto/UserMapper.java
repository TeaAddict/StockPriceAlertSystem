package ooo.stock.StockPriceAlertSystem.dto;

import ooo.stock.StockPriceAlertSystem.model.User;

import java.util.List;

public class UserMapper {
    public static UserResponse toUserResponse(User user){
        return new UserResponse(user.getId(), user.getUserName(), user.getEmail(), user.getRole());
    }

    public static List<UserResponse> toUserResponses(List<User> users){
        return users.stream().map((user) -> new UserResponse(user.getId(), user.getUserName(), user.getEmail(), user.getRole())).toList();
    }


}
