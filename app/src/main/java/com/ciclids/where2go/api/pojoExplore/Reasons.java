
package com.ciclids.where2go.api.pojoExplore;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Reasons implements Parcelable {

    @SerializedName("count")
    @Expose
    private int count;
    @SerializedName("items")
    @Expose
    @Valid
    private List<Item_> items = new ArrayList<Item_>();
    public final static Parcelable.Creator<Reasons> CREATOR = new Creator<Reasons>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Reasons createFromParcel(Parcel in) {
            Reasons instance = new Reasons();
            instance.count = ((int) in.readValue((int.class.getClassLoader())));
            in.readList(instance.items, (com.ciclids.where2go.api.pojoExplore.Item_.class.getClassLoader()));
            return instance;
        }

        public Reasons[] newArray(int size) {
            return (new Reasons[size]);
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
    public List<Item_> getItems() {
        return items;
    }

    /**
     * @param items The items
     */
    public void setItems(List<Item_> items) {
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
