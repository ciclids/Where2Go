
package com.ciclids.where2go.api.pojoExplore;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Todo implements Parcelable {

    @SerializedName("count")
    @Expose
    private int count;
    public final static Parcelable.Creator<Todo> CREATOR = new Creator<Todo>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Todo createFromParcel(Parcel in) {
            Todo instance = new Todo();
            instance.count = ((int) in.readValue((int.class.getClassLoader())));
            return instance;
        }

        public Todo[] newArray(int size) {
            return (new Todo[size]);
        }

    };

    /**
     * @return The count
     */
    public int getCount() {
        return count;
    }

    /**
     * @param count The count
     */
    public void setCount(int count) {
        this.count = count;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(count);
    }

    public int describeContents() {
        return 0;
    }

}
