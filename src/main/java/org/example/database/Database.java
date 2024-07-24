package org.example.database;

import org.example.entities.MediaFile;
import org.example.entities.Playlist;
import org.example.entities.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Database {
    private List<User> users;

    public Database() {
        this.users = new ArrayList<User>(Arrays.asList(
                new User(123, "John", "password1"),
                new User(456,"David", "password22"),
                new User(789,"Tony", "password3333")
        ));
        // Initialize some sample data FOR TESTING
        users.get(0).addPlaylist(new Playlist(123,"Album 001"));
        users.get(0).getPlaylists().get(0).addMediaFile(new MediaFile(3333,"Happy new year","Audio"));
    }

    public Playlist getPlaylist() {
        if (users != null && !users.isEmpty()) {
            User firstUser = users.get(0);
            List<Playlist> playlists = firstUser.getPlaylists();
            if (playlists != null && !playlists.isEmpty()) {
                return playlists.get(0);
            }
        }
        throw new IndexOutOfBoundsException("No playlists available for the first user");
    }

}
