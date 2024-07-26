package org.example.services;

import org.example.abstractions.IUserService;
import org.example.entities.User;
import org.example.repositories.UserRepository;

import java.util.List;

public class UserService implements IUserService {
    private final List<User> users;
    public UserService(UserRepository userRepository) {
        this.users = userRepository.getAllUsers();
    }

    @Override
    public boolean createUser(User user) {
        return false;
    }

    @Override
    public boolean deleteUser(int id) {
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        return false;
    }

    @Override
    public User getUser(int id) {
        return null;
    }

    @Override
    public List<User> listUsers() {
        return null;
    }
}
