
package com.ciclids.where2go.api;

import android.os.Parcel;
import android.os.Parcelable;

import com.ciclids.where2go.api.pojoSearch.Meta;
import com.ciclids.where2go.api.pojoSearch.Response;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class PlacesResponse implements Parcelable {

    @SerializedName("meta")
    @Expose
    private Meta meta;

    @SerializedName("response")
    @Expose
    private Response response;

    public final static Parcelable.Creator<PlacesResponse> CREATOR = new Creator<PlacesResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public PlacesResponse createFromParcel(Parcel in) {
            PlacesResponse instance = new PlacesResponse();
            instance.meta = ((Meta) in.readValue((Meta.class.getClassLoader())));
            instance.response = ((Response) in.readValue((Response.class.getClassLoader())));
            return instance;
        }

        public PlacesResponse[] newArray(int size) {
            return (new PlacesResponse[size]);
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
