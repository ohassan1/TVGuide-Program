package com.TVShowApp.mvc.Models;

//YYYYMMDDhhmmss

public class Show {

    private String name;
    private String description;
    private String icon;
    private String playTime;
    private String endTime;
    private String channel;
    private int startTime;
    private int stopTime;

    public Show(){}

    public Show(String name, String icon, String description, String playTime, String endTime, String channel, int startTime, int stopTime) {

        this.name = name;
        this.icon = icon;
        this.description = description;
        this.playTime = playTime;
        this.endTime = endTime;
        this.channel = channel;
        this.startTime = startTime;
        this.stopTime = stopTime;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlayTime() {
        return playTime;
    }

    public void setPlayTime(String playTime) {
        this.playTime = playTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getStopTime() {
        return stopTime;
    }

    public void setStopTime(int stopTime) {
        this.stopTime = stopTime;
    }
}
