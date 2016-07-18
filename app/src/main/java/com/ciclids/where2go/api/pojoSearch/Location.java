
package com.ciclids.where2go.api.pojoSearch;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Location implements Parcelable {

    @SerializedName("lat")
    @Expose
    private double lat;
    @SerializedName("lng")
    @Expose
    private double lng;
    @SerializedName("distance")
    @Expose
    private int distance;
    @SerializedName("cc")
    @Expose
    private String cc;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("formattedAddress")
    @Expose

    private List<String> formattedAddress = new ArrayList<String>();
    public final static Parcelable.Creator<Location> CREATOR = new Creator<Location>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Location createFromParcel(Parcel in) {
            Location instance = new Location();
            instance.lat = ((double) in.readValue((double.class.getClassLoader())));
            instance.lng = ((double) in.readValue((double.class.getClassLoader())));
            instance.distance = ((int) in.readValue((int.class.getClassLoader())));
            instance.cc = ((String) in.readValue((String.class.getClassLoader())));
            instance.state = ((String) in.readValue((String.class.getClassLoader())));
            instance.country = ((String) in.readValue((String.class.getClassLoader())));
            in.readList(instance.formattedAddress, (java.lang.String.class.getClassLoader()));
            return instance;
        }

        public Location[] newArray(int size) {
            return (new Location[size]);
        }

    };

    /**
     * @return The lat
     */
    public double getLat() {
        return lat;
    }

    /**
     * @param lat The lat
     */
    public void setLat(double lat) {
        this.lat = lat;
    }

    /**
     * @return The lng
     */
    public double getLng() {
        return lng;
    }

    /**
     * @param lng The lng
     */
    public void setLng(double lng) {
        this.lng = lng;
    }

    /**
     * @return The distance
     */
    public int getDistance() {
        return distance;
    }

    /**
     * @param distance The distance
     */
    public void setDistance(int distance) {
        this.distance = distance;
    }

    /**
     * @return The cc
     */
    public String getCc() {
        return cc;
    }

    /**
     * @param cc The cc
     */
    public void setCc(String cc) {
        this.cc = cc;
    }

    /**
     * @return The state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state The state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return The country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country The country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return The formattedAddress
     */
    public List<String> getFormattedAddress() {
        return formattedAddress;
    }

    /**
     * @param formattedAddress The formattedAddress
     */
    public void setFormattedAddress(List<String> formattedAddress) {
        this.formattedAddress = formattedAddress;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(lat);
        dest.writeValue(lng);
        dest.writeValue(distance);
        dest.writeValue(cc);
        dest.writeValue(state);
        dest.writeValue(country);
        dest.writeList(formattedAddress);
    }

    public int describeContents() {
        return 0;
    }

}
