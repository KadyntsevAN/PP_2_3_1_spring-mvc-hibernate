package crud.dao;

import crud.models.User;

import java.util.List;

public interface UserDao {
    public void save(User user);
    public List<User> show();
    public void delete(int id);
    public void update(int id, User updateUser);
    public User find(int id);


}
