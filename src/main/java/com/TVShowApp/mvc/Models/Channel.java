package com.TVShowApp.mvc.Models;


public class Channel {

    private String name;
    private String abbr;
    private String number;
    private String icon;
    private String id;


    public Channel(String name, String abbr, String number, String icon, String idicon) {
        this.name = name;
        this.abbr = abbr;
        this.number = number;
        this.icon = icon;
        this.id = id;
    }


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getAbbr() {
        return abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
