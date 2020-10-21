package dao;

import java.util.List;
import model.User;

public interface UserDao {
    void add(User user);

    User getById(Long id);

    List<User> listUsers();
}
