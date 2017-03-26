package com.multimeleon.android.lifxhttpandroidlibrary.Models.SingleLight;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Color implements Serializable, Parcelable {

    public final static Creator<Color> CREATOR = new Creator<Color>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Color createFromParcel(Parcel in) {
            Color instance = new Color();
            instance.hue = ((int) in.readValue((int.class.getClassLoader())));
            instance.saturation = ((int) in.readValue((int.class.getClassLoader())));
            instance.kelvin = ((int) in.readValue((int.class.getClassLoader())));
            return instance;
        }

        public Color[] newArray(int size) {
            return (new Color[size]);
        }

    };
    private final static long serialVersionUID = 7871245979232084728L;
    @SerializedName("hue")
    @Expose
    private int hue;
    @SerializedName("saturation")
    @Expose
    private int saturation;
    @SerializedName("kelvin")
    @Expose
    private int kelvin;

    public int getHue() {
        return hue;
    }

    public void setHue(int hue) {
        this.hue = hue;
    }

    public int getSaturation() {
        return saturation;
    }

    public void setSaturation(int saturation) {
        this.saturation = saturation;
    }

    public int getKelvin() {
        return kelvin;
    }

    public void setKelvin(int kelvin) {
        this.kelvin = kelvin;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(hue);
        dest.writeValue(saturation);
        dest.writeValue(kelvin);
    }

    public int describeContents() {
        return 0;
    }

}
