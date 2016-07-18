package com.ciclids.where2go.placesMap;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ciclids.where2go.R;
import com.ciclids.where2go.Where2goAppModule;
import com.ciclids.where2go.entities.Place;
import com.ciclids.where2go.lib.di.LibsModule;
import com.ciclids.where2go.placesList.PlaceListPresenter;
import com.ciclids.where2go.placesList.ui.PlaceView;
import com.ciclids.where2go.placesMap.di.DaggerPlacesMapComponent;
import com.ciclids.where2go.placesMap.di.PlacesMapModule;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

import javax.inject.Inject;

public class PlacesMapFragment extends Fragment implements OnMapReadyCallback, PlaceView {
    SupportMapFragment mapFragment;
    GoogleMap gMap = null;
    @Inject
    PlaceListPresenter presenter;

    public PlacesMapFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_map, container, false);
        mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        setupInjection();
        presenter.onCreate();
        mapFragment.newInstance();
        mapFragment.getMapAsync(this);

        return view;
    }

    private void setupInjection() {
        DaggerPlacesMapComponent
                .builder()
                .libsModule(new LibsModule(this))
                .placesMapModule(new PlacesMapModule(this))
                .where2goAppModule(new Where2goAppModule(this.getContext()))
                .build()
                .inject(this);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        gMap = map;
        gMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        startPlaces();
    }

    @Override
    public void onResume() {
        super.onResume();
        MapsInitializer.initialize(getContext());

    }

    @Override
    public void onStart() {
        super.onStart();

    }

    private void startPlaces() {
        if (checkPermission(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION})) {

            String locationProvider = LocationManager.NETWORK_PROVIDER;
            // Or use LocationManager.GPS_PROVIDER
            LocationManager locationManager = (LocationManager) this.getActivity().getSystemService(Context.LOCATION_SERVICE);
            if (locationManager != null) {
                Location lastLocation = locationManager.getLastKnownLocation(locationProvider);
                //    LatLng last=new LatLng(lastLocation.getLatitude(),lastLocation.getLongitude());
                //    gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(last,17));
                presenter.getPlaces(lastLocation);
            }

        }

    }


    private boolean checkPermission(String[] permissions) {
        int result = ActivityCompat.checkSelfPermission(getActivity(), permissions[1]);

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

    @Override
    public void onPlaceError(String error) {
        if (getView() != null)
            Snackbar.make(getView(), "Error al acceder", Snackbar.LENGTH_SHORT).show();

    }

    @Override
    public void setPlaces(List<Place> places) {
        for (Place place : places) {
            gMap.addMarker(new MarkerOptions()
                    .position(new LatLng(place.getLocation()[0], place.getLocation()[1]))
                    .title(place.getName())
                    .snippet(place.getCategories().get(0).getPluralName()));
        }
    }
}

