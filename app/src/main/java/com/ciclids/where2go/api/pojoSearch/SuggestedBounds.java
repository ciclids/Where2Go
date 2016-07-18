
package com.ciclids.where2go.api.pojoSearch;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class SuggestedBounds implements Parcelable {

    @SerializedName("ne")
    @Expose
    @Valid
    private Ne ne;
    @SerializedName("sw")
    @Expose
    @Valid
    private Sw sw;
    public final static Parcelable.Creator<SuggestedBounds> CREATOR = new Creator<SuggestedBounds>() {


        @SuppressWarnings({
                "unchecked"
        })
        public SuggestedBounds createFromParcel(Parcel in) {
            SuggestedBounds instance = new SuggestedBounds();
            instance.ne = ((Ne) in.readValue((Ne.class.getClassLoader())));
            instance.sw = ((Sw) in.readValue((Sw.class.getClassLoader())));
            return instance;
        }

        public SuggestedBounds[] newArray(int size) {
            return (new SuggestedBounds[size]);
        }

    };

    /**
     * @return The ne
     */
    public Ne getNe() {
        return ne;
    }

    /**
     * @param ne The ne
     */
    public void setNe(Ne ne) {
        this.ne = ne;
    }

    /**
     * @return The sw
     */
    public Sw getSw() {
        return sw;
    }

    /**
     * @param sw The sw
     */
    public void setSw(Sw sw) {
        this.sw = sw;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(ne);
        dest.writeValue(sw);
    }

    public int describeContents() {
        return 0;
    }

}
