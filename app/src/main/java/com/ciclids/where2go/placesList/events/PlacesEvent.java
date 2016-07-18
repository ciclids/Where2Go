package com.ciclids.where2go.placesList.events;

import com.ciclids.where2go.entities.Place;

import java.util.List;

/**
 * Created by max on 2016
 */
public class PlacesEvent {
    private String error;
    private List<Place> places;
    public final int TYPE_UNIQUE = 1;
    public final int TYPE_VARIOUS = 0;
    private Place place;
    private int type;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
