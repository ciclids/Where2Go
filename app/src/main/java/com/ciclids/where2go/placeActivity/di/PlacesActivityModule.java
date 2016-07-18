package com.ciclids.where2go.placeActivity.di;

import com.ciclids.where2go.entities.Place;
import com.ciclids.where2go.placeActivity.PlaceActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by max on 2016
 */
@Module
public class PlacesActivityModule {
    private PlaceActivity view;

    @Singleton
    public PlacesActivityModule(PlaceActivity view) {
        this.view = view;
    }

    @Provides
    @Singleton
    List<Place> providePlaces() {
        return new ArrayList<Place>();
    }


    @Provides
    @Singleton
    PlaceActivity providePlacesView() {
        return this.view;
    }


}
