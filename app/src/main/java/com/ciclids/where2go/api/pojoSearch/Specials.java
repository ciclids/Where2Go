
package com.ciclids.where2go.api.pojoSearch;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Specials implements Parcelable {

    @SerializedName("count")
    @Expose
    private int count;
    @SerializedName("items")
    @Expose
    private List<Object> items = new ArrayList<Object>();
    public final static Parcelable.Creator<Specials> CREATOR = new Creator<Specials>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Specials createFromParcel(Parcel in) {
            Specials instance = new Specials();
            instance.count = ((int) in.readValue((int.class.getClassLoader())));
            in.readList(instance.items, (java.lang.Object.class.getClassLoader()));
            return instance;
        }

        public Specials[] newArray(int size) {
            return (new Specials[size]);
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
     * @return The items
     */
    public List<Object> getItems() {
        return items;
    }

    /**
     * @param items The items
     */
    public void setItems(List<Object> items) {
        this.items = items;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(count);
        dest.writeList(items);
    }

    public int describeContents() {
        return 0;
    }

}
