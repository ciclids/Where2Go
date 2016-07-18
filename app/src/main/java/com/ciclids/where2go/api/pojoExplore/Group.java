
package com.ciclids.where2go.api.pojoExplore;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Group implements Parcelable {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("items")
    @Expose
    @Valid
    private List<Item> items = new ArrayList<Item>();
    public final static Parcelable.Creator<Group> CREATOR = new Creator<Group>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Group createFromParcel(Parcel in) {
            Group instance = new Group();
            instance.type = ((String) in.readValue((String.class.getClassLoader())));
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            in.readList(instance.items, (com.ciclids.where2go.api.pojoExplore.Item.class.getClassLoader()));
            return instance;
        }

        public Group[] newArray(int size) {
            return (new Group[size]);
        }

    };

    /**
     * @return The type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return The items
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * @param items The items
     */
    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(type);
        dest.writeValue(name);
        dest.writeList(items);
    }

    public int describeContents() {
        return 0;
    }

}
