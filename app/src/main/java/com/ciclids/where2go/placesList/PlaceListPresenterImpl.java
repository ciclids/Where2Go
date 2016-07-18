package com.ciclids.where2go.placesList;

import android.location.Location;

import com.ciclids.where2go.entities.Place;
import com.ciclids.where2go.lib.EvntBus;
import com.ciclids.where2go.placesList.events.PlacesEvent;
import com.ciclids.where2go.placesList.ui.PlaceView;

import org.greenrobot.eventbus.Subscribe;

import java.util.List;

/**
 * Created by max on 2016
 */
public class PlaceListPresenterImpl implements PlaceListPresenter {

    PlaceView view;
    PlaceListAllInteractor interactor;
    EvntBus evntBus;

    @Override
    public void getPlaces(Location location) {
        interactor.requestData(location);
    }


    public PlaceListPresenterImpl(PlaceView view, PlaceListAllInteractor interactor, EvntBus evntBus) {
        this.view = view;
        this.interactor = interactor;
        this.evntBus = evntBus;
    }


    @Override
    public void setPlaces(List<Place> places) {
        if (view != null) {

            view.setPlaces(places);
        }
    }

    @Override
    public void getPlacesExplored(Location location, String query) {
        interactor.requestExplore(location, query);
    }

    @Override
    public void onCreate() {
        evntBus.register(this);
    }

    @Override
    public void onDestroy() {
        view = null;
        evntBus.unregister(this);
    }


    @Override
    @Subscribe
    public void onEventMainThread(PlacesEvent event) {
        if (event.getType() == event.TYPE_VARIOUS) {
            if (!event.getPlaces().isEmpty()) {
                setPlaces(event.getPlaces());
            }
        } else {
            if (view != null) {
                view.onPlaceError(event.getError());
            }
        }
    }


    @Override
    protected void finalize() throws Throwable {
        evntBus.unregister(this);
        super.finalize();

    }


}
