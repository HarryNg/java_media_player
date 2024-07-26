package org.example.repositories;

import org.example.database.Database;
import org.example.entities.User;

import java.util.List;
import java.util.Optional;

public class UserRepository {
    private final List<User> users;

    public UserRepository(Database database) {
        this.users = database.getUsers();
    }

    public boolean addUser(User user){
        return users.add(user);
    }
    public boolean removeUser(User user){
        return users.remove(user);
    }
    public boolean updateUser(User user){
        Optional<User> updated = this.getUserById(user.getId());
        if(updated.isPresent()){
            updated.get().setPassword(user.getPassword());
            updated.get().setUsername(user.getUsername());
            updated.get().setPlaylists(user.getPlaylists());
        }
        return updated.isPresent();
    }
    public Optional<User> getUserById(int id){
        return users.stream()
                .filter(user -> user.getId()==id)
                .findFirst();
    }
    public List<User> getAllUsers(){
        return users;
    }
}
