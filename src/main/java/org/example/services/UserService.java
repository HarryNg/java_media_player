package org.example.services;

import org.example.abstractions.IUserService;
import org.example.entities.User;
import org.example.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

public class UserService implements IUserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean createUser(User user) {
        return userRepository.addUser(user);
    }

    @Override
    public boolean deleteUser(int id) {
        return userRepository.removeUser(getUser(id).get());
    }

    @Override
    public boolean updateUser(User user) {
        return userRepository.updateUser(user);
    }

    @Override
    public Optional<User> getUser(int id) {
        return userRepository.getUserById(id);
    }

    @Override
    public List<User> listUsers() {
        return userRepository.getAllUsers();
    }

}
