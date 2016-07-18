package com.ciclids.where2go.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by max on 2016
 */
public interface PlacesService {
    @GET("search")
    Call<PlacesResponse> searchQuery(@Query("ll") String latlon,
                                     @Query("client_id") String clientID,
                                     @Query("client_secret") String clientSecret,
                                     @Query("v") int versionDate,
                                     @Query("query") String query);


    @GET("search")
    Call<PlacesResponse> searchAll(@Query("lang") String lang,
                                   @Query("ll") String latlong,
                                   @Query("client_id") String clientID,
                                   @Query("client_secret") String clientSecret,
                                   @Query("v") int versionDate,
                                   @Query("openNow") Boolean open);

    @GET("explore")
    Call<PlacesResponseExplore> explore(@Query("lang") String lang,
                                        @Query("ll") String latlon,
                                        @Query("cat") String cat,
                                        @Query("client_id") String clientID,
                                        @Query("client_secret") String clientSecret,
                                        @Query("v") int versionDate,
                                        @Query("openNow") String open);


}
