package com.ciclids.where2go.placesList;

import android.location.Location;

import com.ciclids.where2go.entities.Place;
import com.ciclids.where2go.placesList.events.PlacesEvent;

import java.util.List;

/**
 * Created by max on 2016
 */
public interface PlaceListPresenter {

    void getPlaces(Location location);

    void setPlaces(List<Place> places);

    void getPlacesExplored(Location location, String query);

    void onDestroy();

    void onCreate();

    void onEventMainThread(PlacesEvent places);

}
