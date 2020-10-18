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

        userService.add(new User("Fedir", "Rudiachenko", "fedia.rudiachenko@gmail.com"));
        userService.add(new User("Anna", "Samoylik", "samoylik@gmail.com"));
        userService.listUsers().forEach(System.out::println);
    }
}
