
package com.ciclids.where2go.api.pojoExplore;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Meta implements Parcelable {

    @SerializedName("code")
    @Expose
    private int code;
    @SerializedName("requestId")
    @Expose
    private String requestId;
    public final static Parcelable.Creator<Meta> CREATOR = new Creator<Meta>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Meta createFromParcel(Parcel in) {
            Meta instance = new Meta();
            instance.code = ((int) in.readValue((int.class.getClassLoader())));
            instance.requestId = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Meta[] newArray(int size) {
            return (new Meta[size]);
        }

    };

    /**
     * @return The code
     */
    public int getCode() {
        return code;
    }

    /**
     * @param code The code
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * @return The requestId
     */
    public String getRequestId() {
        return requestId;
    }

    /**
     * @param requestId The requestId
     */
    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(code);
        dest.writeValue(requestId);
    }

    public int describeContents() {
        return 0;
    }

}
