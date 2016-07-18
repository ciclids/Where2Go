
package com.ciclids.where2go.api.pojoSearch;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class HereNow implements Parcelable {

    @SerializedName("count")
    @Expose
    private int count;
    @SerializedName("summary")
    @Expose
    private String summary;
    @SerializedName("groups")
    @Expose
    private List<Object> groups = new ArrayList<Object>();
    public final static Parcelable.Creator<HereNow> CREATOR = new Creator<HereNow>() {


        @SuppressWarnings({
                "unchecked"
        })
        public HereNow createFromParcel(Parcel in) {
            HereNow instance = new HereNow();
            instance.count = ((int) in.readValue((int.class.getClassLoader())));
            instance.summary = ((String) in.readValue((String.class.getClassLoader())));
            in.readList(instance.groups, (java.lang.Object.class.getClassLoader()));
            return instance;
        }

        public HereNow[] newArray(int size) {
            return (new HereNow[size]);
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

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(count);
        dest.writeValue(summary);
        dest.writeList(groups);
    }

    public int describeContents() {
        return 0;
    }

}
