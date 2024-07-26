package org.example.abstractions;

import org.example.entities.User;

import java.util.List;

public interface IUserService {
    public boolean createUser(User user);
    public boolean deleteUser(int id);
    public boolean updateUser(User user);
    public User getUser(int id);
    public List<User> listUsers();
}
