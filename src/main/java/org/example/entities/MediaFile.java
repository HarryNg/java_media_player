package org.example.entities;

public class MediaFile {
    private final int id;
    private String name;
    private String type;
    private int volume;

    public MediaFile(int id, String name, String type){
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public int getVolume() {
        return volume;
    }

    public boolean play(){
        System.out.println("'" + name + "' Is playing!\n");
        return true;
    }
    public boolean stop(){
        System.out.println("'" + name + "' Is stopped!\n");
        return true;
    }
    public boolean pause(){
        System.out.println("'" + name + "' Is paused!\n");
        return true;
    }
    public void adjustVolume(int volume){
        this.volume = volume;
    }
    public boolean adjustSetting(String setting, int value){
        System.out.println(setting + " This setting value: " + value);
        return true;
    }

    @Override
    public String toString(){
        return "{File id: " + id + ", Name: '" + name + "', Type: '" + type +"'}";
    }
}
