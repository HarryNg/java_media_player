package org.example.repositories;

import org.example.database.Database;
import org.example.entities.Playlist;

import java.util.List;
import java.util.Optional;

public class PlaylistRepository {
    private final List<Playlist> playlists;

    public PlaylistRepository(Database database) {
        this.playlists = database.getPlaylist();
    }

    public boolean addPlaylist(Playlist playlist){
        return playlists.add(playlist);
    }

    public boolean removePlaylist(Playlist playlist){
        return playlists.remove(playlist);
    }
    public Optional<Playlist> getPlaylistById(int id){
        return playlists.stream()
                .filter(item -> item.getId()==id)
                .findFirst();
    }

    public boolean updatePlaylist(Playlist playlist){
        for (Playlist playlist1:playlists){
            if (playlist1.getId()==playlist.getId()){
                playlist1.setName(playlist.getName());
                playlist1.setMediaFiles(playlist.getMediaFiles());
                return true;
            }
        }
        System.out.println("Update playlist failed.");
        return false;
    }

    public List<Playlist> getAllPlaylists(){
        return playlists;
    }
}
