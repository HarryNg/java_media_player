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
        Optional<MediaFile> fileToPlay = mediaFileRepository.getMediaFileById(id);
        if(fileToPlay.isPresent()){
            return fileToPlay.get().play();
        }
        return false;
    }

    @Override
    public boolean pauseMedia(int id) {
        Optional<MediaFile> fileToPause = mediaFileRepository.getMediaFileById(id);
        if(fileToPause.isPresent()){
            return fileToPause.get().pause();
        }
        return false;
    }

    @Override
    public boolean stopMedia(int id) {
        Optional<MediaFile> fileToStop = mediaFileRepository.getMediaFileById(id);
        if(fileToStop.isPresent()){
            return fileToStop.get().stop();
        }
        return false;
    }

    @Override
    public boolean addMediaFile(MediaFile mediaFile) {
        return mediaFileRepository.addMediaFile(mediaFile);
    }

    @Override
    public boolean deleteMediaFile(int id) {
        Optional<MediaFile> deletedFile = mediaFileRepository.getMediaFileById(id);
        if(deletedFile.isEmpty()){
            return false;
        }else {
            return mediaFileRepository.removeMediaFile(deletedFile.get());
        }
    }

    @Override
    public boolean updateMediaFile(MediaFile mediaFile) {
        Optional<MediaFile> updateFile = mediaFileRepository.getMediaFileById(mediaFile.getId());
        if(updateFile.isPresent()){
            return mediaFileRepository.updateMediaFile(mediaFile);
        }else {
            return false;
        }
    }

    @Override
    public boolean adjustVolume(int id, int volume) {
        Optional<MediaFile> file = mediaFileRepository.getMediaFileById(id);
        if(file.isPresent()){
            file.get().setVolume(volume);
        }
        return false;
    }

    // TODOS after implementing audio and video entities
    @Override
    public boolean adjustBrightness(int id, int brightness) {
        return false;
    }

    @Override
    public boolean changeSoundEffect(int id, String effect) {
        return false;
    }
}
