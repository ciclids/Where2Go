package com.ciclids.where2go.placesList;

import com.ciclids.where2go.entities.Place;

import java.util.List;

/**
 * Created by max on 2016
 */
public interface PlaceListRepository {
    void getAllPlaces(Double lat, Double lon);

    void getQueryCategories(Double lat, Double lon, String query);

    void getExploreQuery(Double lat, Double lon, String query);

    void orderByPeople(List<Place> places);

    void orderByCat(List<Place> places);

}
