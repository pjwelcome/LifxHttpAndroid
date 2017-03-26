
package com.multimeleon.android.lifxhttpandroidlibrary.Models.SingleLight;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

class Capabilities implements Serializable, Parcelable {

    public final static Creator<Capabilities> CREATOR = new Creator<Capabilities>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Capabilities createFromParcel(Parcel in) {
            Capabilities instance = new Capabilities();
            instance.hasColor = ((boolean) in.readValue((boolean.class.getClassLoader())));
            instance.hasVariableColorTemp = ((boolean) in.readValue((boolean.class.getClassLoader())));
            instance.hasIr = ((boolean) in.readValue((boolean.class.getClassLoader())));
            instance.hasMultizone = ((boolean) in.readValue((boolean.class.getClassLoader())));
            return instance;
        }

        public Capabilities[] newArray(int size) {
            return (new Capabilities[size]);
        }

    };
    private final static long serialVersionUID = 5277924280511335782L;
    @SerializedName("has_color")
    @Expose
    private boolean hasColor;
    @SerializedName("has_variable_color_temp")
    @Expose
    private boolean hasVariableColorTemp;
    @SerializedName("has_ir")
    @Expose
    private boolean hasIr;
    @SerializedName("has_multizone")
    @Expose
    private boolean hasMultizone;

    public boolean isHasColor() {
        return hasColor;
    }

    public void setHasColor(boolean hasColor) {
        this.hasColor = hasColor;
    }

    public boolean isHasVariableColorTemp() {
        return hasVariableColorTemp;
    }

    public void setHasVariableColorTemp(boolean hasVariableColorTemp) {
        this.hasVariableColorTemp = hasVariableColorTemp;
    }

    public boolean isHasIr() {
        return hasIr;
    }

    public void setHasIr(boolean hasIr) {
        this.hasIr = hasIr;
    }

    public boolean isHasMultizone() {
        return hasMultizone;
    }

    public void setHasMultizone(boolean hasMultizone) {
        this.hasMultizone = hasMultizone;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(hasColor);
        dest.writeValue(hasVariableColorTemp);
        dest.writeValue(hasIr);
        dest.writeValue(hasMultizone);
    }

    public int describeContents() {
        return 0;
    }

}
