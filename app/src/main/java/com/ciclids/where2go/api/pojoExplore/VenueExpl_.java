
package com.ciclids.where2go.api.pojoExplore;

import android.os.Parcel;
import android.os.Parcelable;

import com.ciclids.where2go.api.pojoDomain.Category;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class VenueExpl_ implements Parcelable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("contact")
    @Expose
    @Valid
    private Contact contact;
    @SerializedName("location")
    @Expose
    @Valid
    private Location location;
    @SerializedName("categories")
    @Expose
    @Valid
    private List<Category> categories = new ArrayList<Category>();
    @SerializedName("verified")
    @Expose
    private boolean verified;
    @SerializedName("stats")
    @Expose
    @Valid
    private Stats stats;
    @SerializedName("price")
    @Expose
    @Valid
    private Price price;
    @SerializedName("rating")
    @Expose
    private double rating;
    @SerializedName("ratingColor")
    @Expose
    private String ratingColor;
    @SerializedName("ratingSignals")
    @Expose
    private int ratingSignals;
    @SerializedName("allowMenuUrlEdit")
    @Expose
    private boolean allowMenuUrlEdit;
    @SerializedName("photos")
    @Expose
    @Valid
    private Photos photos;
    @SerializedName("hereNow")
    @Expose
    @Valid
    private HereNow hereNow;
    public final static Parcelable.Creator<VenueExpl_> CREATOR = new Creator<VenueExpl_>() {


        @SuppressWarnings({
                "unchecked"
        })
        public VenueExpl_ createFromParcel(Parcel in) {
            VenueExpl_ instance = new VenueExpl_();
            instance.id = ((String) in.readValue((String.class.getClassLoader())));
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.contact = ((Contact) in.readValue((Contact.class.getClassLoader())));
            instance.location = ((Location) in.readValue((Location.class.getClassLoader())));
            in.readList(instance.categories, (Category.class.getClassLoader()));
            instance.verified = ((boolean) in.readValue((boolean.class.getClassLoader())));
            instance.stats = ((Stats) in.readValue((Stats.class.getClassLoader())));
            instance.price = ((Price) in.readValue((Price.class.getClassLoader())));
            instance.rating = ((double) in.readValue((double.class.getClassLoader())));
            instance.ratingColor = ((String) in.readValue((String.class.getClassLoader())));
            instance.ratingSignals = ((int) in.readValue((int.class.getClassLoader())));
            instance.allowMenuUrlEdit = ((boolean) in.readValue((boolean.class.getClassLoader())));
            instance.photos = ((Photos) in.readValue((Photos.class.getClassLoader())));
            instance.hereNow = ((HereNow) in.readValue((HereNow.class.getClassLoader())));
            return instance;
        }

        public VenueExpl_[] newArray(int size) {
            return (new VenueExpl_[size]);
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
     * @return The price
     */
    public Price getPrice() {
        return price;
    }

    /**
     * @param price The price
     */
    public void setPrice(Price price) {
        this.price = price;
    }

    /**
     * @return The rating
     */
    public double getRating() {
        return rating;
    }

    /**
     * @param rating The rating
     */
    public void setRating(double rating) {
        this.rating = rating;
    }

    /**
     * @return The ratingColor
     */
    public String getRatingColor() {
        return ratingColor;
    }

    /**
     * @param ratingColor The ratingColor
     */
    public void setRatingColor(String ratingColor) {
        this.ratingColor = ratingColor;
    }

    /**
     * @return The ratingSignals
     */
    public int getRatingSignals() {
        return ratingSignals;
    }

    /**
     * @param ratingSignals The ratingSignals
     */
    public void setRatingSignals(int ratingSignals) {
        this.ratingSignals = ratingSignals;
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

    /**
     * @return The photos
     */
    public Photos getPhotos() {
        return photos;
    }

    /**
     * @param photos The photos
     */
    public void setPhotos(Photos photos) {
        this.photos = photos;
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

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeValue(contact);
        dest.writeValue(location);
        dest.writeList(categories);
        dest.writeValue(verified);
        dest.writeValue(stats);
        dest.writeValue(price);
        dest.writeValue(rating);
        dest.writeValue(ratingColor);
        dest.writeValue(ratingSignals);
        dest.writeValue(allowMenuUrlEdit);
        dest.writeValue(photos);
        dest.writeValue(hereNow);
    }

    public int describeContents() {
        return 0;
    }

}
