package org.example;

import org.example.database.Database;
import org.example.entities.MediaFile;
import org.example.repositories.MediaFileRepository;
import org.example.services.MediaFileService;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        MediaFileRepository mediaFileRepository = new MediaFileRepository(database);
        MediaFileService mediaFileService = new MediaFileService(mediaFileRepository);
        System.out.println("Get first media file name: " + mediaFileService.listMediaFiles().get(0).getName());

        // Test get media file by id 3333
        Optional<MediaFile> findByID = mediaFileService.getMediaFile(3333);
        if (findByID.isPresent()){
            System.out.println("\nGet media file by id 3333: " + findByID.toString());
        }
        else {
            System.out.println("Failed to fetch file!!");
        }

        // Test adding media file 2424
        MediaFile movie = new MediaFile(2424, "Tom and Jerry", "video");
        if(mediaFileService.addMediaFile(movie)){
            Optional<MediaFile> added =  mediaFileService.getMediaFile(2424);
            added.ifPresentOrElse(
                    file -> System.out.println("Successfully added file: " + added.toString()),
                    () -> System.out.println("Failed to add file")
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
        if(findByID.isPresent()){
            findByID.get().play();
        }
        // Test pause media file by id 3333
        if(findByID.isPresent()){
            findByID.get().pause();
        }
        // Test stop media file by id 3333
        if(findByID.isPresent()){
            findByID.get().stop();
        }


    }
}