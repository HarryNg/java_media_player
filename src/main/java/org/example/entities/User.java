package org.example.entities;

import org.example.enums.UserRoles;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String username;
    private String password;
    private UserRoles role;
    private List<Playlist> playlists;

    public User(int id, String username, String password, UserRoles role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.playlists = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPlaylists(List<Playlist> playlists) {
        this.playlists = playlists;
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public UserRoles getRole() {
        return role;
    }

    public boolean addPlaylist(Playlist playlist){
        return playlists.add(playlist);
    }
    public boolean removePlaylist(Playlist playlist){
        return playlists.remove(playlist);
    }
}
