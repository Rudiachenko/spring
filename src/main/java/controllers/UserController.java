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
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
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
        return userMapper.toDto(user);
    }

    @GetMapping
    public List<UserResponseDto> getAll() {
        return userService.listUsers().stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }
}
