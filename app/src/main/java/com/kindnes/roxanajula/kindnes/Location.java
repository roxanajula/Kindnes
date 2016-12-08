package com.kindnes.roxanajula.kindnes;

import java.io.Serializable;

/**
 * Created by roxanajula on 08/12/2016.
 */

public class Location implements Serializable {
    private String title;
    private double lat;
    private double lng;

    public Location(String title, double lat, double lng) {
        this.title=title;
        this.lat=lat;
        this.lng=lng;
    }

    public Location() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }
}
