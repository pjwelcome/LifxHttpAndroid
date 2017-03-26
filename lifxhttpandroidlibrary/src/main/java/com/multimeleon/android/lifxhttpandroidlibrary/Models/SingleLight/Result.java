package com.multimeleon.android.lifxhttpandroidlibrary.Models.SingleLight;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Result implements Serializable, Parcelable {

    public final static Creator<Result> CREATOR = new Creator<Result>() {

        @SuppressWarnings({
                "unchecked"
        })
        public Result createFromParcel(Parcel in) {
            Result instance = new Result();
            instance.id = ((String) in.readValue((String.class.getClassLoader())));
            instance.label = ((String) in.readValue((String.class.getClassLoader())));
            instance.status = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Result[] newArray(int size) {
            return (new Result[size]);
        }

    };
    private final static long serialVersionUID = 2122508520507739494L;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("status")
    @Expose
    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(label);
        dest.writeValue(status);
    }

    public int describeContents() {
        return 0;
    }

}
