package org.example;

import org.example.UI.ConsoleUI;
import org.example.database.Database;
import org.example.entities.MediaFile;
import org.example.entities.Playlist;
import org.example.entities.User;
import org.example.entities.VideoFile;
import org.example.repositories.MediaFileRepository;
import org.example.repositories.PlaylistRepository;
import org.example.repositories.UserRepository;
import org.example.services.MediaFileService;
import org.example.services.PlaylistService;
import org.example.services.UserService;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        MediaFileRepository mediaFileRepository = new MediaFileRepository(database);
        MediaFileService mediaFileService = new MediaFileService(mediaFileRepository);
        PlaylistRepository playlistRepository = new PlaylistRepository(database);
        PlaylistService playlistService = new PlaylistService(playlistRepository);
        UserRepository userRepository = new UserRepository(database);
        UserService userService = new UserService(userRepository);

        System.out.println("Get first media file name: " + mediaFileService.listMediaFiles().get(0).getName());

        System.out.println("\n====================Test Media File==================================");
        // Test get media file by id 3333
        Optional<MediaFile> findByID = mediaFileService.getMediaFile(3333);
        if (findByID.isPresent()){
            System.out.println("\nGet media file by id 3333: " + findByID.toString());
        }
        else {
            System.out.println("Failed to fetch file!!");
        }

        // Test adding media file 2424
        VideoFile movie = new VideoFile(2424, "Tom and Jerry", "video");
        if(mediaFileService.addMediaFile(movie)){
            Optional<MediaFile> added =  mediaFileService.getMediaFile(2424);
            added.ifPresentOrElse(
                    file -> System.out.println("Successfully added file: " + added.toString()),
                    () -> System.out.println("Failed to add file")
            );
        }

        // Test updating media file 2424
        VideoFile movieUpdated = new VideoFile(2424, "Tom and Batman", "video");
        if(mediaFileService.updateMediaFile(movieUpdated)){
            Optional<MediaFile> updated = mediaFileService.getMediaFile(2424);
            updated.ifPresentOrElse(
                    file -> System.out.println("Successfully updated file: " + updated.toString()),
                    () -> System.out.println("Failed to update file")
            );
        }

        // Test deleting media file 2424
        if(mediaFileService.deleteMediaFile(2424)){
            Optional<MediaFile> deleted = mediaFileService.getMediaFile(2424);
            if(deleted.isEmpty()){
                System.out.println("Successfully deleted file with id 2424 ");
            }else {
                System.out.println("Failed to delete file" + deleted.toString());
            }
        }

        System.out.println("\n======================================================");
        // Test play media file by id 3333
        mediaFileService.playMedia(3333);
        // Test pause media file by id 3333
        mediaFileService.pauseMedia(3333);
        // Test stop media file by id 3333
        mediaFileService.stopMedia(3333);
        // Test adjust volume media file by id 3333
        System.out.println("Current volume: " + findByID.get().getVolume());
        mediaFileService.adjustVolume(3333,33);
        System.out.println("Adjusted volume: " + findByID.get().getVolume());

        System.out.println("\n=====================Test Playlist=================================");
        // Test create playlist
        Playlist testPlaylist = new Playlist(777,"Symphony 77");
        playlistService.createPlaylist(testPlaylist);
        System.out.println(playlistService.listPlaylists().toString());

        // Test Playlist id 321 is playing media file id 3333
        playlistService.playMediaFromPlaylist(321,3333);
        // Test Playlist id 321 is pausing media file id 3333
        playlistService.pauseMediaInPlaylist(321,3333);
        // Test Playlist id 321 is stopping media file id 3333
        playlistService.stopMediaInPlaylist(321,3333);
        System.out.println("\n=====================Test User=================================");
        System.out.println(userService.listUsers());

        ConsoleUI consoleUI = new ConsoleUI(userService,playlistService,mediaFileService);
        consoleUI.start();
    }
}