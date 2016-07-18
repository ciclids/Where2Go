package com.ciclids.where2go.placesMap.di;

import com.ciclids.where2go.entities.Place;
import com.ciclids.where2go.lib.EvntBus;
import com.ciclids.where2go.placesList.PlaceListAllInteractor;
import com.ciclids.where2go.placesList.PlaceListAllInteractorImpl;
import com.ciclids.where2go.placesList.PlaceListPresenter;
import com.ciclids.where2go.placesList.PlaceListPresenterImpl;
import com.ciclids.where2go.placesList.PlaceListRepository;
import com.ciclids.where2go.placesList.PlaceListRepositoryImpl;
import com.ciclids.where2go.placesList.ui.PlaceView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by max on 2016
 */
@Module
public class PlacesMapModule {
    private PlaceView view;

    @Singleton
    public PlacesMapModule(PlaceView view) {
        this.view = view;
    }

    @Provides
    @Singleton
    List<Place> providePlaces() {
        return new ArrayList<Place>();
    }


    @Provides
    @Singleton
    PlaceView providePlacesView() {
        return this.view;
    }

    @Provides
    @Singleton
    PlaceListAllInteractor providePlaceListAllInteractor(PlaceListRepository repository) {
        return new PlaceListAllInteractorImpl(repository);
    }

    @Provides
    @Singleton
    PlaceListRepository providePlaceListRepository(EvntBus evntBus) {
        return new PlaceListRepositoryImpl(evntBus);
    }

    @Provides
    @Singleton
    PlaceListPresenter providePlaceListPresenter(PlaceView view, PlaceListAllInteractor interactor, EvntBus evntBus) {
        return new PlaceListPresenterImpl(view, interactor, evntBus);
    }

}
