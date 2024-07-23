package org.example.entities;

import java.util.List;

public class User {
    private int id;
    private String username;
    private String password;
    private List<Playlist> playlists;

    public User(int id, String username, String password, List<Playlist> playlists) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.playlists = playlists;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean addPlaylist(Playlist playlist){
        return playlists.add(playlist);
    }
    public boolean removePlaylist(Playlist playlist){
        return playlists.remove(playlist);
    }
}
