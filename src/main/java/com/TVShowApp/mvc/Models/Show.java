package com.TVShowApp.mvc.Models;


public class Show {

    private String name;
    private String description;
    private int showNum;

    public Show(String name, int showNum, String description) {

        this.name = name;
        this.showNum = showNum;
        this.description = description;
    }

    public int getShowNum() {
        return showNum;
    }

    public void setShowNum(int showNum) {
        this.showNum = showNum;
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

}
