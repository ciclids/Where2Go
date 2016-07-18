
package com.ciclids.where2go.api.pojoExplore;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Likes implements Parcelable {

    @SerializedName("count")
    @Expose
    private int count;
    @SerializedName("groups")
    @Expose
    @Valid
    private List<Object> groups = new ArrayList<Object>();
    @SerializedName("summary")
    @Expose
    private String summary;
    public final static Parcelable.Creator<Likes> CREATOR = new Creator<Likes>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Likes createFromParcel(Parcel in) {
            Likes instance = new Likes();
            instance.count = ((int) in.readValue((int.class.getClassLoader())));
            in.readList(instance.groups, (java.lang.Object.class.getClassLoader()));
            instance.summary = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Likes[] newArray(int size) {
            return (new Likes[size]);
        }

    };

    /**
     * @return The count
     */
    public int getCount() {
        return count;
    }

    /**
     * @param count The count
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * @return The groups
     */
    public List<Object> getGroups() {
        return groups;
    }

    /**
     * @param groups The groups
     */
    public void setGroups(List<Object> groups) {
        this.groups = groups;
    }

    /**
     * @return The summary
     */
    public String getSummary() {
        return summary;
    }

    /**
     * @param summary The summary
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(count);
        dest.writeList(groups);
        dest.writeValue(summary);
    }

    public int describeContents() {
        return 0;
    }

}
