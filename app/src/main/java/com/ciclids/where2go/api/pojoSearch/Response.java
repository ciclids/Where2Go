
package com.ciclids.where2go.api.pojoSearch;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Response implements Parcelable {

    @SerializedName("venues")
    @Expose
    private List<Venue> venues = new ArrayList<Venue>();
    @SerializedName("confident")
    @Expose
    private boolean confident;
    public final static Parcelable.Creator<Response> CREATOR = new Creator<Response>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Response createFromParcel(Parcel in) {
            Response instance = new Response();
            in.readList(instance.venues, (Venue.class.getClassLoader()));
            instance.confident = ((boolean) in.readValue((boolean.class.getClassLoader())));
            return instance;
        }

        public Response[] newArray(int size) {
            return (new Response[size]);
        }

    };

    /**
     * @return The venues
     */
    public List<Venue> getVenues() {
        return venues;
    }

    /**
     * @param venues The venues
     */
    public void setVenues(List<Venue> venues) {
        this.venues = venues;
    }

    /**
     * @return The confident
     */
    public boolean isConfident() {
        return confident;
    }

    /**
     * @param confident The confident
     */
    public void setConfident(boolean confident) {
        this.confident = confident;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(venues);
        dest.writeValue(confident);
    }

    public int describeContents() {
        return 0;
    }

}
