package org.example.services;

import org.example.abstractions.IPlaylistService;
import org.example.entities.MediaFile;
import org.example.entities.Playlist;
import org.example.repositories.PlaylistRepository;

import java.util.List;
import java.util.Optional;

public class PlaylistService implements IPlaylistService {
    private final PlaylistRepository playlistRepository;

    public PlaylistService(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    @Override
    public boolean createPlaylist(Playlist playlist) {
        return playlistRepository.addPlaylist(playlist);
    }

    @Override
    public boolean deletePlaylist(int id) {
        Optional<Playlist> deleted = playlistRepository.getPlaylistById(id);
        if(deleted.isEmpty()){
            System.out.println("No such file exists to delete.");
            return false;
        }
        return playlistRepository.removePlaylist(deleted.get());
    }

    @Override
    public boolean updatePlaylist(Playlist playlist) {
        return playlistRepository.updatePlaylist(playlist);
    }

    @Override
    public Optional<Playlist> getPlaylist(int id) {
        return playlistRepository.getPlaylistById(id);
    }

    @Override
    public List<Playlist> listPlaylists() {
        return playlistRepository.getAllPlaylists();
    }

    @Override
    public boolean playMediaFromPlaylist(int playlistId, int mediaFileId) {
        Optional<Playlist> playlist = playlistRepository.getPlaylistById(playlistId);
        if(playlist.isPresent()){
            return playlist.get().playMedia(mediaFileId);
        }
        return false;
    }

    @Override
    public boolean pauseMediaInPlaylist(int playlistId, int mediaFileId) {
        Optional<Playlist> paused = playlistRepository.getPlaylistById(playlistId);
        if(paused.isPresent()){
            return paused.get().pauseMedia(mediaFileId);
        }
        return false;
    }

    @Override
    public boolean stopMediaInPlaylist(int playlistId, int mediaFileId) {
        Optional<Playlist> stopped = playlistRepository.getPlaylistById(playlistId);
        if (stopped.isPresent()){
            return stopped.get().stopMedia(mediaFileId);
        }
        return false;
    }
}
