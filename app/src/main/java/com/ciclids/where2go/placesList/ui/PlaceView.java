package com.ciclids.where2go.placesList.ui;

import com.ciclids.where2go.entities.Place;

import java.util.List;

/**
 * Created by max on 2016
 */
public interface PlaceView {
    void onPlaceError(String error);

    void setPlaces(List<Place> places);
}
