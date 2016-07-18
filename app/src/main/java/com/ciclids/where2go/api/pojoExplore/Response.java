
package com.ciclids.where2go.api.pojoExplore;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Response implements Parcelable {

    @SerializedName("suggestedRadius")
    @Expose
    private int suggestedRadius;
    @SerializedName("headerLocation")
    @Expose
    private String headerLocation;
    @SerializedName("headerFullLocation")
    @Expose
    private String headerFullLocation;
    @SerializedName("headerLocationGranularity")
    @Expose
    private String headerLocationGranularity;
    @SerializedName("totalResults")
    @Expose
    private int totalResults;
    @SerializedName("suggestedBounds")
    @Expose
    @Valid
    private SuggestedBounds suggestedBounds;
    @SerializedName("groups")
    @Expose
    @Valid
    private List<Group> groups = new ArrayList<Group>();
    public final static Parcelable.Creator<Response> CREATOR = new Creator<Response>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Response createFromParcel(Parcel in) {
            Log.e("login parcel", in.createStringArray().toString());
            Response instance = new Response();
            instance.suggestedRadius = ((int) in.readValue((int.class.getClassLoader())));
            instance.headerLocation = ((String) in.readValue((String.class.getClassLoader())));
            instance.headerFullLocation = ((String) in.readValue((String.class.getClassLoader())));
            instance.headerLocationGranularity = ((String) in.readValue((String.class.getClassLoader())));
            instance.totalResults = ((int) in.readValue((int.class.getClassLoader())));
            instance.suggestedBounds = ((SuggestedBounds) in.readValue((SuggestedBounds.class.getClassLoader())));
            in.readList(instance.groups, (com.ciclids.where2go.api.pojoExplore.Group.class.getClassLoader()));
            return instance;
        }

        public Response[] newArray(int size) {
            return (new Response[size]);
        }

    };

    /**
     * @return The suggestedRadius
     */
    public int getSuggestedRadius() {
        return suggestedRadius;
    }

    /**
     * @param suggestedRadius The suggestedRadius
     */
    public void setSuggestedRadius(int suggestedRadius) {
        this.suggestedRadius = suggestedRadius;
    }

    /**
     * @return The headerLocation
     */
    public String getHeaderLocation() {
        return headerLocation;
    }

    /**
     * @param headerLocation The headerLocation
     */
    public void setHeaderLocation(String headerLocation) {
        this.headerLocation = headerLocation;
    }

    /**
     * @return The headerFullLocation
     */
    public String getHeaderFullLocation() {
        return headerFullLocation;
    }

    /**
     * @param headerFullLocation The headerFullLocation
     */
    public void setHeaderFullLocation(String headerFullLocation) {
        this.headerFullLocation = headerFullLocation;
    }

    /**
     * @return The headerLocationGranularity
     */
    public String getHeaderLocationGranularity() {
        return headerLocationGranularity;
    }

    /**
     * @param headerLocationGranularity The headerLocationGranularity
     */
    public void setHeaderLocationGranularity(String headerLocationGranularity) {
        this.headerLocationGranularity = headerLocationGranularity;
    }

    /**
     * @return The totalResults
     */
    public int getTotalResults() {
        return totalResults;
    }

    /**
     * @param totalResults The totalResults
     */
    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    /**
     * @return The suggestedBounds
     */
    public SuggestedBounds getSuggestedBounds() {
        return suggestedBounds;
    }

    /**
     * @param suggestedBounds The suggestedBounds
     */
    public void setSuggestedBounds(SuggestedBounds suggestedBounds) {
        this.suggestedBounds = suggestedBounds;
    }

    /**
     * @return The groups
     */
    public List<Group> getGroups() {
        return groups;
    }

    /**
     * @param groups The groups
     */
    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(suggestedRadius);
        dest.writeValue(headerLocation);
        dest.writeValue(headerFullLocation);
        dest.writeValue(headerLocationGranularity);
        dest.writeValue(totalResults);
        dest.writeValue(suggestedBounds);
        dest.writeList(groups);
    }

    public int describeContents() {
        return 0;
    }

}
