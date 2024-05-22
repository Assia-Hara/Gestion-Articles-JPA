package ma.formation.jpa.dao;

import java.util.List;

import ma.formation.jpa.service.model.User;

public interface IDao {
    User findById(Long id);
    void delete(Long id);
    List<User> findAllUsers();
    User getUserByUsername(String username);
    void save(User user);
    void deleteAll();

    public void addUser(User user);
    public void renewPassword(String username, String newPassword);
}