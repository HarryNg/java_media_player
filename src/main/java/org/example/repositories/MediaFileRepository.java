package org.example.repositories;

import org.example.database.Database;
import org.example.entities.MediaFile;

import java.util.List;
import java.util.Optional;

public class MediaFileRepository {
    private final List<MediaFile> mediaFiles;

    public MediaFileRepository(Database database){
        this.mediaFiles = database.getPlaylist().getMediaFiles();
    }

    public Optional<MediaFile> getMediaFileById(int id){
        return mediaFiles.stream().filter(file -> file.getId()==id).findFirst();
    }
    public List<MediaFile> getAllMediaFiles(){
        return mediaFiles;
    }

    public boolean removeMediaFile(MediaFile mediaFile){
        return mediaFiles.remove(mediaFile);
    }
    public boolean addMediaFile(MediaFile mediaFile){
        return mediaFiles.add(mediaFile);
    }



}
