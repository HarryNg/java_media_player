package org.example.entities;

public class VideoFile extends MediaFile{
    private int brightness;
    public VideoFile(int id, String name, String type) {
        super(id, name, "Video");
        brightness = 65;
    }

    public int getBrightness() {
        return brightness;
    }

    public void adjustBrightness(int brightness) {
        this.brightness = brightness;
    }

    @Override
    public boolean adjustSetting(String setting, int value) {
        switch (setting.toLowerCase()){
            case "volume": adjustVolume(value);
            case "brightness": adjustBrightness(value);
            default:super.adjustSetting(setting,value);
        }
        return true;
    }
}
