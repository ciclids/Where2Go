
package com.ciclids.where2go.api.pojoSearch;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Ne implements Parcelable {

    @SerializedName("lat")
    @Expose
    private double lat;
    @SerializedName("lng")
    @Expose
    private double lng;
    public final static Parcelable.Creator<Ne> CREATOR = new Creator<Ne>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Ne createFromParcel(Parcel in) {
            Ne instance = new Ne();
            instance.lat = ((double) in.readValue((double.class.getClassLoader())));
            instance.lng = ((double) in.readValue((double.class.getClassLoader())));
            return instance;
        }

        public Ne[] newArray(int size) {
            return (new Ne[size]);
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
