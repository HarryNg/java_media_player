package org.example.abstractions;

import org.example.entities.Playlist;

import java.util.List;
import java.util.Optional;

public interface IPlaylistService {
    public boolean createPlaylist(Playlist playlist);
    public boolean deletePlaylist(int id);
    public boolean updatePlaylist(Playlist playlist);
    public Optional<Playlist> getPlaylist(int id);
    public List<Playlist> listPlaylists();
    public boolean playMediaFromPlaylist(int playlistId, int mediaFileId);
    public boolean pauseMediaInPlaylist(int playlistId, int mediaFileId);
    public boolean stopMediaInPlaylist(int playlistId, int mediaFileId);

}
