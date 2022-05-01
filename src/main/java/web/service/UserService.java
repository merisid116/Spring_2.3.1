package web.service;

import web.entity.User;

import java.util.List;

public interface UserService {
     List<User> index();
     User showUser(int id);
     void save(User user);
     void update(int id, User user);
     void delete(int id);
}
