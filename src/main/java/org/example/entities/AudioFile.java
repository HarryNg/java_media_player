package org.example.entities;

public class AudioFile extends MediaFile{
    private String soundEffect;
    public AudioFile(int id, String name, String type) {
        super(id, name, "Audio");
        this.soundEffect = "No Effect";
    }

    public String getSoundEffect() {
        return soundEffect;
    }

    public void changeSoundEffect(String effect){
        this.soundEffect = effect;
    }

    @Override
    public boolean adjustSetting(String setting, int value) {
        switch (setting.toLowerCase()){
            case "volume" : adjustVolume(value);
            case "soundEffect" : changeSoundEffect(Integer.toString(value));
            default: super.adjustSetting(setting,value);
        }
        return true;
    }
}
