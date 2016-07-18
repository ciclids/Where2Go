package com.ciclids.where2go.placesList;


import android.location.Location;
import android.support.annotation.NonNull;

/**
 * Created by max on 2016
 */
public class PlaceListAllInteractorImpl implements PlaceListAllInteractor {

    private PlaceListRepository repository;

    public PlaceListAllInteractorImpl(PlaceListRepository repository) {
        this.repository = repository;
    }

    @Override
    public void requestData(@NonNull Location location) {
        if (location != null) {
            repository.getAllPlaces(location.getLatitude(), location.getLongitude());

        }

    }

    @Override
    public void requestQuery(@NonNull Location location, @NonNull String query) {
        repository.getQueryCategories(location.getLatitude(), location.getLongitude(), query);

    }

    @Override
    public void requestExplore(Location location, String query) {
        repository.getExploreQuery(location.getLatitude(), location.getLongitude(), query);
    }


}
