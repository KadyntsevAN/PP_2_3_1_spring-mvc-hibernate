package crud.services;

import crud.dao.UserDao;
import crud.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public void save(User user) {
        userDao.save(user);
    }


    @Override
    public List<User> show() {
        return userDao.show();
    }

    @Transactional
    @Override
    public void delete(int id) {
        userDao.delete(id);
    }

    @Transactional
    @Override
    public void update(int id, User updateUser) {
        userDao.update(id, updateUser);
    }


    @Override
    public User find(int id) {
        return userDao.find(id);
    }
}
