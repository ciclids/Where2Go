
package com.ciclids.where2go.api.pojoSearch;

import android.os.Parcel;
import android.os.Parcelable;

import com.ciclids.where2go.api.pojoDomain.Category;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Venue implements Parcelable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("contact")
    @Expose

    private Contact contact;
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("categories")
    @Expose
    private List<Category> categories = new ArrayList<Category>();
    @SerializedName("verified")
    @Expose
    private boolean verified;
    @SerializedName("stats")
    @Expose
    private Stats stats;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("specials")
    @Expose
    private Specials specials;
    @SerializedName("hereNow")
    @Expose

    private HereNow hereNow;
    @SerializedName("referralId")
    @Expose
    private String referralId;
    @SerializedName("venueChains")
    @Expose
    private List<Object> venueChains = new ArrayList<Object>();
    @SerializedName("allowMenuUrlEdit")
    @Expose
    private boolean allowMenuUrlEdit;
    public final static Parcelable.Creator<Venue> CREATOR = new Creator<Venue>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Venue createFromParcel(Parcel in) {
            Venue instance = new Venue();
            instance.id = ((String) in.readValue((String.class.getClassLoader())));
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.contact = ((Contact) in.readValue((Contact.class.getClassLoader())));
            instance.location = ((Location) in.readValue((Location.class.getClassLoader())));
            in.readList(instance.categories, (Category.class.getClassLoader()));
            instance.verified = ((boolean) in.readValue((boolean.class.getClassLoader())));
            instance.stats = ((Stats) in.readValue((Stats.class.getClassLoader())));
            instance.url = ((String) in.readValue((String.class.getClassLoader())));
            instance.specials = ((Specials) in.readValue((Specials.class.getClassLoader())));
            instance.hereNow = ((HereNow) in.readValue((HereNow.class.getClassLoader())));
            instance.referralId = ((String) in.readValue((String.class.getClassLoader())));
            in.readList(instance.venueChains, (java.lang.Object.class.getClassLoader()));
            instance.allowMenuUrlEdit = ((boolean) in.readValue((boolean.class.getClassLoader())));
            return instance;
        }

        public Venue[] newArray(int size) {
            return (new Venue[size]);
        }

    };

    /**
     * @return The id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(String id) {
        this.id = id;
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
     * @return The contact
     */
    public Contact getContact() {
        return contact;
    }

    /**
     * @param contact The contact
     */
    public void setContact(Contact contact) {
        this.contact = contact;
    }

    /**
     * @return The location
     */
    public Location getLocation() {
        return location;
    }

    /**
     * @param location The location
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * @return The categories
     */
    public List<Category> getCategories() {
        return categories;
    }

    /**
     * @param categories The categories
     */
    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    /**
     * @return The verified
     */
    public boolean isVerified() {
        return verified;
    }

    /**
     * @param verified The verified
     */
    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    /**
     * @return The stats
     */
    public Stats getStats() {
        return stats;
    }

    /**
     * @param stats The stats
     */
    public void setStats(Stats stats) {
        this.stats = stats;
    }

    /**
     * @return The url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return The specials
     */
    public Specials getSpecials() {
        return specials;
    }

    /**
     * @param specials The specials
     */
    public void setSpecials(Specials specials) {
        this.specials = specials;
    }

    /**
     * @return The hereNow
     */
    public HereNow getHereNow() {
        return hereNow;
    }

    /**
     * @param hereNow The hereNow
     */
    public void setHereNow(HereNow hereNow) {
        this.hereNow = hereNow;
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
     * @return The venueChains
     */
    public List<Object> getVenueChains() {
        return venueChains;
    }

    /**
     * @param venueChains The venueChains
     */
    public void setVenueChains(List<Object> venueChains) {
        this.venueChains = venueChains;
    }

    /**
     * @return The allowMenuUrlEdit
     */
    public boolean isAllowMenuUrlEdit() {
        return allowMenuUrlEdit;
    }

    /**
     * @param allowMenuUrlEdit The allowMenuUrlEdit
     */
    public void setAllowMenuUrlEdit(boolean allowMenuUrlEdit) {
        this.allowMenuUrlEdit = allowMenuUrlEdit;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeValue(contact);
        dest.writeValue(location);
        dest.writeList(categories);
        dest.writeValue(verified);
        dest.writeValue(stats);
        dest.writeValue(url);
        dest.writeValue(specials);
        dest.writeValue(hereNow);
        dest.writeValue(referralId);
        dest.writeList(venueChains);
        dest.writeValue(allowMenuUrlEdit);
    }

    public int describeContents() {
        return 0;
    }

}
