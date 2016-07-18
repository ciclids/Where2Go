
package com.ciclids.where2go.api.pojoExplore;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Flags implements Parcelable {

    @SerializedName("outsideRadius")
    @Expose
    private boolean outsideRadius;
    public final static Parcelable.Creator<Flags> CREATOR = new Creator<Flags>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Flags createFromParcel(Parcel in) {
            Flags instance = new Flags();
            instance.outsideRadius = ((boolean) in.readValue((boolean.class.getClassLoader())));
            return instance;
        }

        public Flags[] newArray(int size) {
            return (new Flags[size]);
        }

    };

    /**
     * @return The outsideRadius
     */
    public boolean isOutsideRadius() {
        return outsideRadius;
    }

    /**
     * @param outsideRadius The outsideRadius
     */
    public void setOutsideRadius(boolean outsideRadius) {
        this.outsideRadius = outsideRadius;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(outsideRadius);
    }

    public int describeContents() {
        return 0;
    }

}
