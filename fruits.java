package com.example.franklinsierra.frutas;

public class fruits {
    private int icon;
    private String name;
    private String origin;
    private String info;

    public fruits(int icon, String name, String origin,String info) {
        this.icon = icon;
        this.name = name;
        this.origin = origin;
        this.info=info;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
