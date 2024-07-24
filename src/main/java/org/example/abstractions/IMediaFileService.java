package org.example.abstractions;

import org.example.entities.MediaFile;

import java.util.List;
import java.util.Optional;

public interface IMediaFileService {
    public boolean addMediaFile(MediaFile mediaFile);
    public boolean deleteMediaFile(int id);
    public boolean updateMediaFile(MediaFile mediaFile);
    public Optional<MediaFile> getMediaFile(int id);
    public List<MediaFile> listMediaFiles();
    public boolean playMedia(int id);
    public boolean pauseMedia(int id);
    public boolean stopMedia(int id);
    public boolean adjustVolume(int id, int volume);
    public boolean adjustBrightness(int id, int brightness);
    public boolean changeSoundEffect(int id, String effect);
}
