package org.example.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Playlist {
    private int id;
    private String name;
    private List<MediaFile> mediaFiles;

    public Playlist(int id, String name) {
        this.id = id;
        this.name = name;
        this.mediaFiles = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMediaFiles(List<MediaFile> mediaFiles) {
        this.mediaFiles = mediaFiles;
    }

    public List<MediaFile> getMediaFiles() {
        return mediaFiles;
    }

    public boolean addMediaFile(MediaFile mediaFile){
        return mediaFiles.add(mediaFile);
    }

    public boolean removeMediaFile(MediaFile mediaFile){
        if(!mediaFiles.contains(mediaFile)){
            return false;
        }
        return mediaFiles.remove(mediaFile);
    }
    private Optional<MediaFile> getMediaFileById(int id){
        return mediaFiles.stream()
                .filter(mediaFile -> mediaFile.getId()==id)
                .findFirst();
    }
    public boolean playMedia(int mediaFileId){
        Optional<MediaFile> mediaFileOptional = getMediaFileById(mediaFileId);
        mediaFileOptional.ifPresent(MediaFile::play);
        return mediaFileOptional.isPresent();
    }
    public boolean pauseMedia(int mediaFileId){
        Optional<MediaFile> mediaFileOptional = getMediaFileById(mediaFileId);
        mediaFileOptional.ifPresent(MediaFile::pause);
        return mediaFileOptional.isPresent();
    }
    public boolean stopMedia(int mediaFileId){
        Optional<MediaFile> mediaFileOptional = getMediaFileById(mediaFileId);
        mediaFileOptional.ifPresent(MediaFile::stop);
        return mediaFileOptional.isPresent();
    }

    @Override
    public String toString(){
        String combined = "\n{Playlist name: '" + name + "' id: " + id + "\n";
        for (MediaFile mediaFile:mediaFiles){
            combined += mediaFile.toString() + "\n";
        }
        return combined+"}\n";
    }

}
