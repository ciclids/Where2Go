package com.ciclids.where2go.placesList;

import android.content.res.Resources;
import android.util.Log;

import com.ciclids.where2go.BuildConfig;
import com.ciclids.where2go.R;
import com.ciclids.where2go.api.PlacesClient;
import com.ciclids.where2go.api.PlacesResponse;
import com.ciclids.where2go.api.PlacesResponseExplore;
import com.ciclids.where2go.api.PlacesService;
import com.ciclids.where2go.api.pojoExplore.Group;
import com.ciclids.where2go.api.pojoExplore.Item;
import com.ciclids.where2go.api.pojoExplore.VenueExpl_;
import com.ciclids.where2go.api.pojoSearch.Venue;
import com.ciclids.where2go.entities.Place;
import com.ciclids.where2go.lib.EvntBus;
import com.ciclids.where2go.placesList.events.PlacesEvent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by max on 2016
 */
public class PlaceListRepositoryImpl implements PlaceListRepository {


    PlacesService service = new PlacesClient().getPlacesService();
    private final EvntBus evntBus;

    public PlaceListRepositoryImpl(EvntBus evntBus) {

        this.evntBus = evntBus;
    }

    @Override
    public void getAllPlaces(Double lat, Double lon) {
        String strLocation = String.valueOf(lat) + "," + String.valueOf(lon);
        Call<PlacesResponse> call = service.searchAll("es", strLocation, BuildConfig.FSQ_API, BuildConfig.FSQ_SECRET, 20160707, 100000);
        callingAll(call);
    }


    @Override
    public void getQueryCategories(Double lat, Double lon, String query) {
        String strLocation = String.valueOf(lat) + "," + String.valueOf(lon);

        Call<PlacesResponse> call = service.searchQuery(strLocation, BuildConfig.FSQ_API, BuildConfig.FSQ_SECRET, 20160110, query);
        callingAll(call);
    }

    @Override
    public void getExploreQuery(Double lat, Double lon, String query) {
        String strLocation = String.valueOf(lat) + "," + String.valueOf(lon);
        Call<PlacesResponseExplore> call = service.explore("es", strLocation, query, BuildConfig.FSQ_API, BuildConfig.FSQ_SECRET, 20160701, "true");
        callingExplorer(call);
    }


    private void callingAll(Call call) {

        call.enqueue(new Callback<PlacesResponse>() {

            @Override
            public void onResponse(Call<PlacesResponse> call, Response<PlacesResponse> response) {
                if (response.isSuccess()) {
                    PlacesResponse result = response.body();
                    List<Venue> venues = result.getResponse().getVenues();
                    ArrayList<Place> places = new ArrayList<>();

                    for (Venue venue : venues) {
                        try {

                                Double[] loc = {venue.getLocation().getLat(), venue.getLocation().getLng()};

                                String icon = venue.getCategories().get(0).getIcon().getPrefix() + "bg_32.png";

                                String url = venue.getUrl();
                                if (url == null) {
                                    url = "https://es.foursquare.com/v/" + venue.getId();
                                }

                                places.add(new Place(
                                        venue.getId(),
                                        venue.getName(),
                                        loc,
                                        venue.getCategories(),
                                        url,
                                        icon,
                                        venue.getHereNow().getCount()
                                ));

                                orderByCat(places);

                        } catch (Exception e) {
                            Log.e("error de listado", e.getLocalizedMessage());
                        }
                    }
                    post(places);
                }
            }

            @Override
            public void onFailure(Call<PlacesResponse> call, Throwable t) {
                Log.d("errror", "Error repo");

                post(Resources.getSystem().getString(R.string.error_connection_repo));
            }
        });

    }

    private void callingExplorer(Call call) {

        call.enqueue(new Callback<PlacesResponseExplore>() {

            @Override
            public void onResponse(Call<PlacesResponseExplore> call, Response<PlacesResponseExplore> response) {
                if (response.isSuccess()) {
                    PlacesResponseExplore result = response.body();


                    if (result != null) {
                        List<Group> groups = result.getResponse().getGroups();

                        List<Place> places = new ArrayList<>();

                        List<VenueExpl_> venues = new ArrayList<>();
                        for (Group gp : groups) {
                            List<Item> items = gp.getItems();
                            for (Item it : items) {
                                venues.add(it.getVenueExpl());
                            }
                        }

                        for (VenueExpl_ venue : venues) {
                            try {
                                Log.d("v", venue.getId());
                                Double[] loc = {venue.getLocation().getLat(), venue.getLocation().getLng()};

                                String icon = venue.getCategories().get(0).getIcon().getPrefix() + "bg_32.png";

                                String url = venue.getId();
                                if (url == null) {
                                    url = "https://es.foursquare.com/v/" + venue.getId();
                                }

                                places.add(new Place(
                                        venue.getId(),
                                        venue.getName(),
                                        loc,
                                        venue.getCategories(),
                                        url,
                                        icon,
                                        venue.getHereNow().getCount()
                                ));

                                orderByCat(places);

                            } catch (Exception e) {

                                Log.e("error de listado", e.getLocalizedMessage());
                            }
                        }
                        post(places);
                    }
                }
            }

            @Override
            public void onFailure(Call<PlacesResponseExplore> call, Throwable t) {

                Log.d("errror", "Error repo");

                post(Resources.getSystem().getString(R.string.error_connection_repo));
            }
        });

    }

    @Override
    public void orderByPeople(List<Place> places) {
        Collections.sort(places, new Comparator<Place>() {
            @Override
            public int compare(Place place, Place t1) {
                return place.getHereNow() + t1.getHereNow();
            }
        });
    }

    @Override
    public void orderByCat(List<Place> places) {
        Collections.sort(places, new Comparator<Place>() {
            @Override
            public int compare(Place place, Place t1) {
                return place.getCategories().get(0).getShortName().compareTo(t1.getCategories().get(0).getShortName());
            }
        });

    }

    private void post(List<Place> places) {
        PlacesEvent events = new PlacesEvent();
        events.setPlaces(places);
        events.setType(events.TYPE_VARIOUS);
        evntBus.post(events);
    }

    private void post(String error) {
        PlacesEvent events = new PlacesEvent();
        events.setError(error);
        evntBus.post(events);
    }


}
