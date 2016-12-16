package com.kindnes.roxanajula.kindnes;

import java.io.Serializable;

/**
 * Created by roxanajula on 16/12/2016.
 */

public class Organisation implements Serializable {
    public String id;
    private String logo;
    private String name;
    private String description;
    private String website;

    public Organisation(String id, String logo, String name, String description, String website) {
        this.id=id;
        this.logo=logo;
        this.name=name;
        this.description=description;
        this.website=website;
    }

    public Organisation() {

    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getId() {
        return id;
    }

    public void setId(String id){
        this.id=id;
    }
}
