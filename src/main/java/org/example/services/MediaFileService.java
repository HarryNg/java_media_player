package org.example.services;

import org.example.abstractions.IMediaFileService;
import org.example.entities.MediaFile;
import org.example.repositories.MediaFileRepository;

import java.util.List;
import java.util.Optional;

public class MediaFileService implements IMediaFileService {
    private final MediaFileRepository mediaFileRepository;

    public MediaFileService(MediaFileRepository mediaFileRepository) {
        this.mediaFileRepository = mediaFileRepository;
    }

    @Override
    public Optional<MediaFile> getMediaFile(int id) {
        return mediaFileRepository.getMediaFileById(id);
    }

    @Override
    public List<MediaFile> listMediaFiles() {
        return mediaFileRepository.getAllMediaFiles();
    }

    @Override
    public boolean playMedia(int id) {
        return false;
    }

    @Override
    public boolean pauseMedia(int id) {
        return false;
    }

    @Override
    public boolean stopMedia(int id) {
        return false;
    }

    @Override
    public boolean addMediaFile(MediaFile mediaFile) {
        return false;
    }

    @Override
    public boolean deleteMediaFile(int id) {
        return false;
    }

    @Override
    public boolean updateMediaFile(MediaFile mediaFile) {
        return false;
    }

    @Override
    public boolean adjustVolume(int id, int volume) {
        return false;
    }

    @Override
    public boolean adjustBrightness(int id, int brightness) {
        return false;
    }

    @Override
    public boolean changeSoundEffect(int id, String effect) {
        return false;
    }
}
