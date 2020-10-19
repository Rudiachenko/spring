package application;

import config.AppConfig;
import model.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.UserService;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);

        userService.add(new User("bob@gmail.com", "bob", "123456"));
        userService.add(new User("alice@gmail.com", "alice", "password"));
        userService.listUsers().forEach(System.out::println);
    }
}
