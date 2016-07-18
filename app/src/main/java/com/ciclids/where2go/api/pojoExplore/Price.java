
package com.ciclids.where2go.api.pojoExplore;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Price implements Parcelable {

    @SerializedName("tier")
    @Expose
    private int tier;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("currency")
    @Expose
    private String currency;
    public final static Parcelable.Creator<Price> CREATOR = new Creator<Price>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Price createFromParcel(Parcel in) {
            Price instance = new Price();
            instance.tier = ((int) in.readValue((int.class.getClassLoader())));
            instance.message = ((String) in.readValue((String.class.getClassLoader())));
            instance.currency = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Price[] newArray(int size) {
            return (new Price[size]);
        }

    };

    /**
     * @return The tier
     */
    public int getTier() {
        return tier;
    }

    /**
     * @param tier The tier
     */
    public void setTier(int tier) {
        this.tier = tier;
    }

    /**
     * @return The message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message The message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return The currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * @param currency The currency
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(tier);
        dest.writeValue(message);
        dest.writeValue(currency);
    }

    public int describeContents() {
        return 0;
    }

}
