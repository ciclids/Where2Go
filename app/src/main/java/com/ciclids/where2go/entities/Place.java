package com.ciclids.where2go.entities;

import com.ciclids.where2go.api.pojoDomain.Category;

import java.util.List;

/**
 * Created by max on 2016
 */
public class Place {

    private String id;
    private String name;
    private Double[] location;
    private List<Category> categories;
    private String url;
    private String icon;
    private int hereNow;


    public Place(String id, String name, Double[] location, List<Category> categories, String url, String icon, int hereNow) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.categories = categories;
        this.url = url;
        this.icon = icon;
        this.hereNow = hereNow;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double[] getLocation() {
        return location;
    }

    public void setLocation(Double[] location) {
        this.location = location;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getHereNow() {
        return hereNow;
    }

    public void setHereNow(int hereNow) {
        this.hereNow = hereNow;
    }


}
