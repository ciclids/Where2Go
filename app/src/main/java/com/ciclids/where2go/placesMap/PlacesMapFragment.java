package com.ciclids.where2go.placesMap;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ciclids.where2go.R;
import com.ciclids.where2go.Where2goAppModule;
import com.ciclids.where2go.api.pojoDomain.Category;
import com.ciclids.where2go.entities.Place;
import com.ciclids.where2go.lib.di.LibsModule;
import com.ciclids.where2go.placesList.PlaceListPresenter;
import com.ciclids.where2go.placesList.ui.PlaceView;
import com.ciclids.where2go.placesMap.di.DaggerPlacesMapComponent;
import com.ciclids.where2go.placesMap.di.PlacesMapModule;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.HashMap;
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
        setupInjection();

        mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.newInstance();
        mapFragment.getMapAsync(this);
        presenter.onCreate();


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

            final String locationProvider = LocationManager.NETWORK_PROVIDER;
            // Or use LocationManager.GPS_PROVIDER
            LocationManager locationManager = (LocationManager) this.getActivity().getSystemService(Context.LOCATION_SERVICE);
            if (locationManager != null) {
                Location lastLocation = locationManager.getLastKnownLocation(locationProvider);

                lastLocation.setLatitude(39.4695969);
                lastLocation.setLongitude(-0.371201);
                LatLng last = new LatLng(lastLocation.getLatitude(), lastLocation.getLongitude());
                gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(last, 18));
                presenter.getPlaces(lastLocation);
                gMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                    @Override
                    public void onMapClick(LatLng point) {
                        Log.d("Map", "Map clicked");
                        Location newLoc=new Location(locationProvider);
                        newLoc.setLatitude(point.latitude);
                        newLoc.setLongitude(point.longitude);

                        presenter.getPlaces(newLoc);
                    }
                });
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
            Snackbar.make(getView(), R.string.error_de_acceso, Snackbar.LENGTH_SHORT).show();

    }

    @Override
    public void setPlaces(List<Place> places) {
        for (Place place : places) {
            Category cat = place.getCategories().get(0);
            int res = compareCategories(cat.getShortName());
            Marker marker = gMap.addMarker(new MarkerOptions()
                    .position(new LatLng(place.getLocation()[0], place.getLocation()[1]))
                    .title(place.getName())
                    .icon(BitmapDescriptorFactory.fromResource(res))
                    .snippet(cat.getPluralName()));
        }
    }

    public int compareCategories(@NonNull String category) {
      //  Log.d("cate", category);
        HashMap<String, Integer> imagenes = new HashMap<>();
        imagenes.put("Espacio para eventos", R.mipmap.cinema);
        imagenes.put("Hotel", R.mipmap.hotel);
        imagenes.put("Teatros", R.mipmap.mask);
        imagenes.put("Parques", R.mipmap.tulip);
        imagenes.put("Jardín", R.mipmap.tulip);
        imagenes.put("Lugar de música", R.mipmap.saxophone);
        imagenes.put("Restaurante", R.mipmap.hamburger);
        imagenes.put("Café", R.mipmap.coctail);
        imagenes.put("Ropa", R.mipmap.ropa);
        imagenes.put("Tienda de mujeres", R.mipmap.ropa);
        imagenes.put("Zapatos", R.mipmap.ropa);
        imagenes.put("Banco", R.mipmap.banco);

        if (imagenes.containsKey(category)) {
            return imagenes.get(category);
        }
        return R.mipmap.crystal;
    }
}

