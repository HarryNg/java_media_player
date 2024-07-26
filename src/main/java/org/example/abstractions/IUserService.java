package org.example.abstractions;

import org.example.entities.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    public boolean createUser(User user);
    public boolean deleteUser(int id);
    public boolean updateUser(User user);
    public Optional<User> getUser(int id);
    public List<User> listUsers();
}
