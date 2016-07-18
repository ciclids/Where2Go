
package com.ciclids.where2go.api;

import android.os.Parcel;
import android.os.Parcelable;

import com.ciclids.where2go.api.pojoExplore.Meta;
import com.ciclids.where2go.api.pojoExplore.Response;
import com.ciclids.where2go.api.pojoSearch.Valid;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class PlacesResponseExplore implements Parcelable {

    @SerializedName("meta")
    @Expose
    @Valid
    private Meta meta;
    @SerializedName("response")
    @Expose
    @Valid
    private Response response;
    public final static Parcelable.Creator<PlacesResponseExplore> CREATOR = new Creator<PlacesResponseExplore>() {


        @SuppressWarnings({
                "unchecked"
        })
        public PlacesResponseExplore createFromParcel(Parcel in) {
            PlacesResponseExplore instance = new PlacesResponseExplore();
            instance.meta = ((Meta) in.readValue((Meta.class.getClassLoader())));
            instance.response = ((Response) in.readValue((Response.class.getClassLoader())));
            return instance;
        }

        public PlacesResponseExplore[] newArray(int size) {
            return (new PlacesResponseExplore[size]);
        }

    };

    /**
     * @return The meta
     */
    public Meta getMeta() {
        return meta;
    }

    /**
     * @param meta The meta
     */
    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    /**
     * @return The response
     */
    public Response getResponse() {
        return response;
    }

    /**
     * @param response The response
     */
    public void setResponse(Response response) {
        this.response = response;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(meta);
        dest.writeValue(response);
    }

    public int describeContents() {
        return 0;
    }

}
