package com.ciclids.where2go.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by max on 2016
 */
public class PlacesClient {
    private Retrofit retrofit;
    private final static String BASE_URL = "https://api.foursquare.com/v2/venues/";

    public PlacesClient() {
        Retrofit myRetrofit;
        myRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        this.retrofit = myRetrofit;
    }

    public PlacesService getPlacesService() {
        return retrofit.create(PlacesService.class);
    }
}
