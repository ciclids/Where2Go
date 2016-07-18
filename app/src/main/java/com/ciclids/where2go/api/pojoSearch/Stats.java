
package com.ciclids.where2go.api.pojoSearch;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Stats implements Parcelable {

    @SerializedName("checkinsCount")
    @Expose
    private int checkinsCount;
    @SerializedName("usersCount")
    @Expose
    private int usersCount;
    @SerializedName("tipCount")
    @Expose
    private int tipCount;
    public final static Parcelable.Creator<Stats> CREATOR = new Creator<Stats>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Stats createFromParcel(Parcel in) {
            Stats instance = new Stats();
            instance.checkinsCount = ((int) in.readValue((int.class.getClassLoader())));
            instance.usersCount = ((int) in.readValue((int.class.getClassLoader())));
            instance.tipCount = ((int) in.readValue((int.class.getClassLoader())));
            return instance;
        }

        public Stats[] newArray(int size) {
            return (new Stats[size]);
        }

    };

    /**
     * @return The checkinsCount
     */
    public int getCheckinsCount() {
        return checkinsCount;
    }

    /**
     * @param checkinsCount The checkinsCount
     */
    public void setCheckinsCount(int checkinsCount) {
        this.checkinsCount = checkinsCount;
    }

    /**
     * @return The usersCount
     */
    public int getUsersCount() {
        return usersCount;
    }

    /**
     * @param usersCount The usersCount
     */
    public void setUsersCount(int usersCount) {
        this.usersCount = usersCount;
    }

    /**
     * @return The tipCount
     */
    public int getTipCount() {
        return tipCount;
    }

    /**
     * @param tipCount The tipCount
     */
    public void setTipCount(int tipCount) {
        this.tipCount = tipCount;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(checkinsCount);
        dest.writeValue(usersCount);
        dest.writeValue(tipCount);
    }

    public int describeContents() {
        return 0;
    }

}
