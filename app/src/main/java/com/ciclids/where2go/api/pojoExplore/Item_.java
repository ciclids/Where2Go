
package com.ciclids.where2go.api.pojoExplore;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Item_ implements Parcelable {

    @SerializedName("summary")
    @Expose
    private String summary;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("reasonName")
    @Expose
    private String reasonName;
    public final static Parcelable.Creator<Item_> CREATOR = new Creator<Item_>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Item_ createFromParcel(Parcel in) {
            Item_ instance = new Item_();
            instance.summary = ((String) in.readValue((String.class.getClassLoader())));
            instance.type = ((String) in.readValue((String.class.getClassLoader())));
            instance.reasonName = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Item_[] newArray(int size) {
            return (new Item_[size]);
        }

    };

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
     * @return The reasonName
     */
    public String getReasonName() {
        return reasonName;
    }

    /**
     * @param reasonName The reasonName
     */
    public void setReasonName(String reasonName) {
        this.reasonName = reasonName;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(summary);
        dest.writeValue(type);
        dest.writeValue(reasonName);
    }

    public int describeContents() {
        return 0;
    }

}
