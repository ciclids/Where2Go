
package com.ciclids.where2go.api.pojoExplore;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Item implements Parcelable {

    @SerializedName("reasons")
    @Expose
    @Valid
    private Reasons reasons;
    @SerializedName("venueExpl")
    @Expose
    @Valid
    private VenueExpl_ venueExpl;
    @SerializedName("tips")
    @Expose
    @Valid
    private List<Tip> tips = new ArrayList<Tip>();
    @SerializedName("referralId")
    @Expose
    private String referralId;
    @SerializedName("flags")
    @Expose
    @Valid
    private Flags flags;
    public final static Parcelable.Creator<Item> CREATOR = new Creator<Item>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Item createFromParcel(Parcel in) {
            Item instance = new Item();
            instance.reasons = ((Reasons) in.readValue((Reasons.class.getClassLoader())));
            instance.venueExpl = ((VenueExpl_) in.readValue((VenueExpl_.class.getClassLoader())));
            in.readList(instance.tips, (com.ciclids.where2go.api.pojoExplore.Tip.class.getClassLoader()));
            instance.referralId = ((String) in.readValue((String.class.getClassLoader())));
            instance.flags = ((Flags) in.readValue((Flags.class.getClassLoader())));
            return instance;
        }

        public Item[] newArray(int size) {
            return (new Item[size]);
        }

    };

    /**
     * @return The reasons
     */
    public Reasons getReasons() {
        return reasons;
    }

    /**
     * @param reasons The reasons
     */
    public void setReasons(Reasons reasons) {
        this.reasons = reasons;
    }

    /**
     * @return The venueExpl
     */
    public VenueExpl_ getVenueExpl() {
        return venueExpl;
    }

    /**
     * @param venueExpl The venueExpl
     */
    public void setVenueExpl(VenueExpl_ venueExpl) {
        this.venueExpl = venueExpl;
    }

    /**
     * @return The tips
     */
    public List<Tip> getTips() {
        return tips;
    }

    /**
     * @param tips The tips
     */
    public void setTips(List<Tip> tips) {
        this.tips = tips;
    }

    /**
     * @return The referralId
     */
    public String getReferralId() {
        return referralId;
    }

    /**
     * @param referralId The referralId
     */
    public void setReferralId(String referralId) {
        this.referralId = referralId;
    }

    /**
     * @return The flags
     */
    public Flags getFlags() {
        return flags;
    }

    /**
     * @param flags The flags
     */
    public void setFlags(Flags flags) {
        this.flags = flags;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(reasons);
        dest.writeValue(venueExpl);
        dest.writeList(tips);
        dest.writeValue(referralId);
        dest.writeValue(flags);
    }

    public int describeContents() {
        return 0;
    }

}
