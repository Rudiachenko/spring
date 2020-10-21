package controllers;

import dto.UserResponseDto;
import model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    protected UserResponseDto toDto(User user) {
        UserResponseDto userDto = new UserResponseDto();
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setLogin(user.getLogin());
        userDto.setPassword(user.getPassword());
        return userDto;
    }
}
