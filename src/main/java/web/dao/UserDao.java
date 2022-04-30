package web.dao;

import org.springframework.stereotype.Repository;
import web.entity.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDao implements Dao{
    @PersistenceContext()
    private EntityManager entityManager;

    @Override
    public List<User> index() {
        return entityManager.createQuery("select user from User user", User.class).getResultList();
    }

    @Override
    @Transactional
    public User showUser(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @Transactional
    public void save(User user) {
        entityManager.persist(user);
        entityManager.close();
    }

    @Override
    @Transactional
    public void update(int id, User user) {
        entityManager.merge(user);
    }

    @Override
    @Transactional
    public void delete(int id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);
        }
    }

}
