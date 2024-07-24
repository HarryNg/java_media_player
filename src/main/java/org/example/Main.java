package org.example;

import org.example.database.Database;
import org.example.repositories.MediaFileRepository;
import org.example.services.MediaFileService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        MediaFileRepository mediaFileRepository = new MediaFileRepository(database);
        MediaFileService mediaFileService = new MediaFileService(mediaFileRepository);
        System.out.println("The first media file name: " + mediaFileService.listMediaFiles().get(0).getName());
    }
}