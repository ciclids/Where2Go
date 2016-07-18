
package com.ciclids.where2go.api.pojoSearch;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Sw implements Parcelable {

    @SerializedName("lat")
    @Expose
    private double lat;
    @SerializedName("lng")
    @Expose
    private double lng;
    public final static Parcelable.Creator<Sw> CREATOR = new Creator<Sw>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Sw createFromParcel(Parcel in) {
            Sw instance = new Sw();
            instance.lat = ((double) in.readValue((double.class.getClassLoader())));
            instance.lng = ((double) in.readValue((double.class.getClassLoader())));
            return instance;
        }

        public Sw[] newArray(int size) {
            return (new Sw[size]);
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

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(lat);
        dest.writeValue(lng);
    }

    public int describeContents() {
        return 0;
    }

}
