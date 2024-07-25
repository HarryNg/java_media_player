package org.example.repositories;

import org.example.database.Database;
import org.example.entities.MediaFile;

import java.util.List;
import java.util.Optional;

public class MediaFileRepository {
    private final List<MediaFile> mediaFiles;

    public MediaFileRepository(Database database){
        this.mediaFiles = database.getMediaFilesList();
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
    public boolean updateMediaFile(MediaFile mediaFile){
        Optional<MediaFile> mediaFileOptional = mediaFiles.stream()
                .filter(mediaFile1 -> mediaFile1.getId() == mediaFile.getId())
                .findFirst();
        if(mediaFileOptional.isPresent()){
            mediaFileOptional.get().setName(mediaFile.getName());
            mediaFileOptional.get().setType(mediaFile.getType());
            mediaFileOptional.get().adjustVolume(mediaFile.getVolume());
        };
        return mediaFileOptional.isPresent();
    }


}
