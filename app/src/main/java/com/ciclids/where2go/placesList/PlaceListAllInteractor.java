package com.ciclids.where2go.placesList;

import android.location.Location;

/**
 * Created by max on 2016
 */
public interface PlaceListAllInteractor {
    void requestData(Location location);

    void requestQuery(Location location, String query);

    void requestExplore(Location location, String query);
}
