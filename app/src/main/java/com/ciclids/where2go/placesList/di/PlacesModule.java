package com.ciclids.where2go.placesList.di;

import com.ciclids.where2go.entities.Place;
import com.ciclids.where2go.lib.EvntBus;
import com.ciclids.where2go.lib.ImageLoader;
import com.ciclids.where2go.placesList.PlaceListAllInteractor;
import com.ciclids.where2go.placesList.PlaceListAllInteractorImpl;
import com.ciclids.where2go.placesList.PlaceListPresenter;
import com.ciclids.where2go.placesList.PlaceListPresenterImpl;
import com.ciclids.where2go.placesList.PlaceListRepository;
import com.ciclids.where2go.placesList.PlaceListRepositoryImpl;
import com.ciclids.where2go.placesList.adapters.PlaceListAdapter;
import com.ciclids.where2go.placesList.ui.OnPlaceClickListener;
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
public class PlacesModule {
    private PlaceView view;
    private OnPlaceClickListener clickListener;

    @Singleton
    public PlacesModule(PlaceView view, OnPlaceClickListener clickListener) {
        this.view = view;
        this.clickListener = clickListener;
    }

    @Provides
    @Singleton
    List<Place> providePlaces() {
        return new ArrayList<Place>();
    }

    @Provides
    @Singleton
    OnPlaceClickListener provideOnPlaceClickListener() {
        return this.clickListener;
    }

    @Provides
    @Singleton
    PlaceListAdapter providePlaceListAdapter(List<Place> items, OnPlaceClickListener clickListener, ImageLoader imageLoader) {
        return new PlaceListAdapter(items, clickListener, imageLoader);
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
