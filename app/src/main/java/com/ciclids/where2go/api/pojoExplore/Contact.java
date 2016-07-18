
package com.ciclids.where2go.api.pojoExplore;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Contact implements Parcelable {

    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("formattedPhone")
    @Expose
    private String formattedPhone;
    public final static Parcelable.Creator<Contact> CREATOR = new Creator<Contact>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Contact createFromParcel(Parcel in) {
            Contact instance = new Contact();
            instance.phone = ((String) in.readValue((String.class.getClassLoader())));
            instance.formattedPhone = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Contact[] newArray(int size) {
            return (new Contact[size]);
        }

    };

    /**
     * @return The phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone The phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return The formattedPhone
     */
    public String getFormattedPhone() {
        return formattedPhone;
    }

    /**
     * @param formattedPhone The formattedPhone
     */
    public void setFormattedPhone(String formattedPhone) {
        this.formattedPhone = formattedPhone;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(phone);
        dest.writeValue(formattedPhone);
    }

    public int describeContents() {
        return 0;
    }

}
