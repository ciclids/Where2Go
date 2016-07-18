package com.ciclids.where2go.placesList.ui;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ciclids.where2go.R;
import com.ciclids.where2go.Where2goAppModule;
import com.ciclids.where2go.entities.Place;
import com.ciclids.where2go.lib.EvntBus;
import com.ciclids.where2go.lib.di.LibsModule;
import com.ciclids.where2go.placeActivity.PlaceActivity;
import com.ciclids.where2go.placesList.PlaceListPresenter;
import com.ciclids.where2go.placesList.adapters.PlaceListAdapter;
import com.ciclids.where2go.placesList.di.DaggerPlacesComponent;
import com.ciclids.where2go.placesList.di.PlacesModule;
import com.ciclids.where2go.placesList.events.PlacesEvent;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by max on 2016
 */
public class PlacesFragment extends Fragment implements PlaceView, OnPlaceClickListener, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    @Inject
    PlaceListAdapter adapter;
    @Inject
    PlaceListPresenter presenter;
    @Inject
    EvntBus eventBus;

    @Bind(R.id.recycler_places)
    RecyclerView recyclerPlaces;
    private Location lastLocation;

    GoogleApiClient googleApiClient;

    public PlacesFragment() {
    }


    @Override
    public void onPlaceError(String error) {
        if (this.getView() != null) {
            Snackbar.make(this.getView(), error, Snackbar.LENGTH_SHORT).show();
        }
    }

    @Override
    public void setPlaces(List<Place> places) {
        adapter.setItems(places);
    }

    @Override
    public void onPlaceClicked(Place place) {
        Intent intent = new Intent(this.getContext(), PlaceActivity.class);
        startActivity(intent);
        PlacesEvent event = new PlacesEvent();
        event.setType(event.TYPE_UNIQUE);
        event.setPlace(place);
        eventBus.post(event);


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_places_list, container, false);
        ButterKnife.bind(this, view);
        setupInjection();
        setupRecyclerView();
        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupGoogleAPIClient();
        presenter.onCreate();
        searchPlaces();

    }

    @Override
    public void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onStop() {
        googleApiClient.disconnect();
        super.onStop();
    }

    @Override
    public void onStart() {
        googleApiClient.connect();
        super.onStart();
    }


    private void searchPlaces() {
        if (checkPermission(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION})) {

            String locationProvider = LocationManager.GPS_PROVIDER;
            // Or use LocationManager.GPS_PROVIDER
            LocationManager locationManager = (LocationManager) this.getActivity().getSystemService(Context.LOCATION_SERVICE);
            lastLocation = locationManager.getLastKnownLocation(locationProvider);
            presenter.getPlaces(lastLocation);
        }

    }

    private void setupGoogleAPIClient() {

        if (checkPermission(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION})) {

            if (googleApiClient == null) {
                googleApiClient = new GoogleApiClient.Builder(this.getActivity())
                        .addConnectionCallbacks(this)
                        .addOnConnectionFailedListener(this)
                        .addApi(LocationServices.API)
                        .build();

            }

        }
    }


    private boolean checkPermission(String[] permissions) {
        int result = ActivityCompat.checkSelfPermission(getActivity(), permissions[0]);

        if (result == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    this.getActivity(),
                    permissions,
                    0
            );


        }
        return false;
    }

    private void setupInjection() {
        DaggerPlacesComponent
                .builder()
                .libsModule(new LibsModule(this))
                .placesModule(new PlacesModule(this, this))
                .where2goAppModule(new Where2goAppModule(this.getContext()))
                .build()
                .inject(this);
    }

    private void setupRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerPlaces.setLayoutManager(layoutManager);
        recyclerPlaces.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {

        super.onDestroyView();
        ButterKnife.unbind(this);
        presenter.onDestroy();
    }


    @Override
    public void onConnected(@Nullable Bundle bundle) {
        if (checkPermission(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION})) {

            lastLocation = LocationServices.FusedLocationApi.getLastLocation(googleApiClient);
        }
    }

    @Override
    public void onConnectionSuspended(int i) {
        googleApiClient.connect();
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Snackbar.make(this.getView(), connectionResult.getErrorMessage(), Snackbar.LENGTH_SHORT).show();

    }


}
