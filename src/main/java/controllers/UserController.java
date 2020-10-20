package controllers;

import dto.UserResponseDto;
import java.util.List;
import java.util.stream.Collectors;
import model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final ConvertModel convertModel;

    public UserController(UserService userService, ConvertModel convertModel) {
        this.userService = userService;
        this.convertModel = convertModel;
    }

    @GetMapping("/inject")
    public String injectUsersIntoDb() {
        userService.add(new User("taras@gmail.com", "taras", "password"));
        userService.add(new User("andrew@gmail.com", "andrew", "password"));
        userService.add(new User("sveta@gmail.com", "sveta", "password"));
        userService.add(new User("hanna@gmail.com", "hanna", "password"));
        return "Users injected successfully ";
    }

    @GetMapping("{userId}")
    public UserResponseDto getUser(@PathVariable Long userId) {
        User user = userService.getById(userId);
        return convertModel.toDto(user);
    }

    @GetMapping("/get")
    public List<UserResponseDto> getAll() {
        return userService.listUsers().stream()
                .map(convertModel::toDto)
                .collect(Collectors.toList());
    }
}
