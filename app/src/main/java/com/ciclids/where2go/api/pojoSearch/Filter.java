
package com.ciclids.where2go.api.pojoSearch;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Filter implements Parcelable {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("key")
    @Expose
    private String key;
    public final static Parcelable.Creator<Filter> CREATOR = new Creator<Filter>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Filter createFromParcel(Parcel in) {
            Filter instance = new Filter();
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.key = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Filter[] newArray(int size) {
            return (new Filter[size]);
        }

    };

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
     * @return The key
     */
    public String getKey() {
        return key;
    }

    /**
     * @param key The key
     */
    public void setKey(String key) {
        this.key = key;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(name);
        dest.writeValue(key);
    }

    public int describeContents() {
        return 0;
    }

}
