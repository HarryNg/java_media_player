package org.example.entities;

import java.util.ArrayList;
import java.util.List;

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
    public boolean playMedia(int mediaFileId){
        return true;
    }
    public boolean pauseMedia(int mediaFileId){
        return true;
    }
    public boolean stopMedia(int mediaFileId){
        return true;
    }

}
