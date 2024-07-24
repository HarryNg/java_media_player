package org.example.repositories;

import org.example.database.Database;
import org.example.entities.MediaFile;

import java.util.List;
import java.util.Optional;

public class MediaFileRepository {
    private final List<MediaFile> mediaFiles;

    public MediaFileRepository(Database database){
        this.mediaFiles = database.getPlaylist().get(0).getMediaFiles();
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
        for (MediaFile mediaFile1:mediaFiles){
            if(mediaFile1.getId()==mediaFile.getId()){
                mediaFile1.setName(mediaFile.getName());
                mediaFile1.setType(mediaFile.getType());
                mediaFile1.setVolume(mediaFile.getVolume());
                return true;
            }
        }
        return false;
    }


}
