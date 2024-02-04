package crud.dao;

import crud.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> show() {
        TypedQuery<User> query = entityManager.createQuery("from User", User.class);
        return query.getResultList();
    }

    @Override
    public void delete(int id) {
        User userToDelete = find(id);
        if (userToDelete != null) {
            entityManager.remove(userToDelete);
        }
    }
    @Override
    public void update(int id, User updateUser) {
        if (find(id) != null) {
            entityManager.merge(updateUser);
        }
    }
    @Override
    public User find(int id) {
        return entityManager.find(User.class, id);
    }
}
