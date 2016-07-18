
package com.ciclids.where2go.api.pojoSearch;

import android.os.Parcel;
import android.os.Parcelable;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Contact implements Parcelable {

    public final static Parcelable.Creator<Contact> CREATOR = new Creator<Contact>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Contact createFromParcel(Parcel in) {
            Contact instance = new Contact();
            return instance;
        }

        public Contact[] newArray(int size) {
            return (new Contact[size]);
        }

    };

    public void writeToParcel(Parcel dest, int flags) {
    }

    public int describeContents() {
        return 0;
    }

}
