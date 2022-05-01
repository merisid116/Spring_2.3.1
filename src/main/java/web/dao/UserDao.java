package web.dao;

import web.entity.User;

import java.util.List;

public interface UserDao {
    List<User> index();
    User showUser(int id);
    void save(User user);
    void update(int id, User user);
    void delete(int id);
}

