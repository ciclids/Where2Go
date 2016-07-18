
package com.ciclids.where2go.api.pojoExplore;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Photos implements Parcelable {

    @SerializedName("count")
    @Expose
    private int count;
    @SerializedName("groups")
    @Expose
    @Valid
    private List<Object> groups = new ArrayList<Object>();
    public final static Parcelable.Creator<Photos> CREATOR = new Creator<Photos>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Photos createFromParcel(Parcel in) {
            Photos instance = new Photos();
            instance.count = ((int) in.readValue((int.class.getClassLoader())));
            in.readList(instance.groups, (java.lang.Object.class.getClassLoader()));
            return instance;
        }

        public Photos[] newArray(int size) {
            return (new Photos[size]);
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

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(count);
        dest.writeList(groups);
    }

    public int describeContents() {
        return 0;
    }

}
