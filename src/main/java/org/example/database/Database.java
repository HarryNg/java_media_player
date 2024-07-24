package org.example.database;

import org.example.entities.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Database {
    private List<User> users;
    private List<Playlist> playlists;
    private List<MediaFile> mediaFiles;

    public Database() {
        this.mediaFiles = new ArrayList<>(Arrays.asList(
                new AudioFile(3333,"Happy new year","Audio"),
                new AudioFile(1122,"Rhythm of the rain","Audio"),
                new VideoFile(2345,"Avenger 2","Video"),
                new VideoFile(4846,"Ice Age","Video"),
                new VideoFile(6666,"Star war","Video")
        ));
        this.playlists = new ArrayList<>(Arrays.asList(
                new Playlist(321, "RockMetal"),
                new Playlist(654, "BlockBuster")
        ));

        // Populate Playlist 1 and 2 with media files for testing purpose
        for (int i =0; i<3; i++){
            playlists.get(0).addMediaFile(mediaFiles.get(i));
        }
        for (int i =3; i<mediaFiles.size(); i++){
            playlists.get(1).addMediaFile(mediaFiles.get(i));
        }

        this.users = new ArrayList<>(Arrays.asList(
                new User(19, "John", "password1"),
                new User(56,"David", "password22"),
                new User(72,"Tony", "password3333")
        ));

    }

    public List<Playlist> getPlaylist() {
        return playlists;
    }
    public List<MediaFile> getMediaFilesList() {
        return mediaFiles;
    }

}
