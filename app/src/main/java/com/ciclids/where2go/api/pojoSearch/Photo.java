
package com.ciclids.where2go.api.pojoSearch;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Photo implements Parcelable {

    @SerializedName("prefix")
    @Expose
    private String prefix;
    @SerializedName("suffix")
    @Expose
    private String suffix;
    public final static Parcelable.Creator<Photo> CREATOR = new Creator<Photo>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Photo createFromParcel(Parcel in) {
            Photo instance = new Photo();
            instance.prefix = ((String) in.readValue((String.class.getClassLoader())));
            instance.suffix = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Photo[] newArray(int size) {
            return (new Photo[size]);
        }

    };

    /**
     * @return The prefix
     */
    public String getPrefix() {
        return prefix;
    }

    /**
     * @param prefix The prefix
     */
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    /**
     * @return The suffix
     */
    public String getSuffix() {
        return suffix;
    }

    /**
     * @param suffix The suffix
     */
    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(prefix);
        dest.writeValue(suffix);
    }

    public int describeContents() {
        return 0;
    }

}
